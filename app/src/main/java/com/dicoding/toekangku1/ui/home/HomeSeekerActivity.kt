package com.dicoding.toekangku1.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.datathreadsforworker.WorkerData
import com.dicoding.toekangku1.data.dataworkerlocal.UserData
import com.dicoding.toekangku1.data.dataworkerlocal.UserLocal
import com.dicoding.toekangku1.databinding.ActivityHomeSeekerBinding
import com.dicoding.toekangku1.ui.ViewModelFactory
import com.dicoding.toekangku1.ui.chat.ChatActivity
import com.dicoding.toekangku1.ui.home.detail.DetailWorkerActivity
import com.dicoding.toekangku1.ui.home.listworker.ListWorkerActivity
import com.dicoding.toekangku1.ui.profile.ProfileActivity
import com.dicoding.toekangku1.ui.thread.ThreadSeekerActivity
import com.dicoding.toekangku1.ui.thread.detail.DetailPostActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeSeekerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeSeekerBinding
    private var token = ""
    private var type = ""
    private lateinit var adapter : WorkerAdapter
    private val homeViewModel: HomeViewModel by viewModels { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeSeekerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_home
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.menu_home -> {
                    true
                }
                R.id.menu_postingan -> {
                    val intent = Intent(applicationContext, ThreadSeekerActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_percakapan -> {
                    val intent = Intent(applicationContext, ChatActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_profil -> {
                    val intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        binding.recommendedWorkersRecyclerView.isNestedScrollingEnabled = false
        binding.relatedPostsRecyclerView.isNestedScrollingEnabled = false

        setupView()
        observeSessionToken()
        homeViewModel.getSession(token, type)
        setupAction()
        getWorkerRecommendations()
        relatedPost()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun observeSessionToken() {
        homeViewModel.sessionData.observe(this, { (token, type) ->
            if (type == "Pelanggan") {
                val intent = Intent(this, HomeWorkerActivity::class.java)
                startActivity(intent)
                finish() // Closes HomeSeekerActivity
            } else {
                // Assuming 'currentUser' is the user object you want to use
                val currentUser = UserData.users.first { it.type == "Pelanggan" }
                setupViewForSeeker(currentUser)
            }
        })
    }

    private fun setupViewForSeeker(user: UserLocal) {
        binding.lokasiPengguna.text = user.locationCity
        binding.namaPengguna.text = user.name
        if (user.pictureUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(R.drawable.ic_user) // Replace with your default image
                .into(binding.profileSeeker)
        } else {
            Glide.with(this)
                .load(user.pictureUrl)
                .placeholder(R.drawable.ic_user) // Replace with your default image
                .into(binding.profileSeeker)
        }
    }

    private fun getWorkerRecommendations() {
        // Filter the users list for workers of type "Pekerja"
        val workerRecommendations = UserData.users.filter { it.type == "Pekerja" }

        // Create and set the adapter for the RecyclerView
        val adapter = WorkerAdapter(workerRecommendations)
        adapter.onItemClick = { selectedWorker ->
            val intent = Intent(this@HomeSeekerActivity, DetailWorkerActivity::class.java)
            intent.putExtra("WORKER_ID", selectedWorker.id)
            startActivity(intent)
        }
        binding.recommendedWorkersRecyclerView.adapter = adapter
    }

    private fun relatedPost(){
        val relatedPosts = WorkerData.workers // Assuming this is your list of related posts
        val relatedAdapter = RelatedAdapter(relatedPosts)

        binding.relatedPostsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.relatedPostsRecyclerView.adapter = relatedAdapter
    }

    private fun setupAction(){
        binding.selengkapnyaLabel.setOnClickListener{
            startActivity(Intent(this, ListWorkerActivity::class.java))
        }

        binding.relatedPostsRecyclerView.setOnClickListener{
            startActivity(Intent(this, DetailPostActivity::class.java))
        }
    }
}