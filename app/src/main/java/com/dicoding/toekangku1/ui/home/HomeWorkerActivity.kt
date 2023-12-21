package com.dicoding.toekangku1.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.datathreadforseeker.SeekerData
import com.dicoding.toekangku1.data.dataworkerlocal.UserData
import com.dicoding.toekangku1.data.dataworkerlocal.UserLocal
import com.dicoding.toekangku1.databinding.ActivityHomeWorkerBinding
import com.dicoding.toekangku1.ui.ViewModelFactory
import com.dicoding.toekangku1.ui.chat.ChatActivity
import com.dicoding.toekangku1.ui.profile.ProfileActivity
import com.dicoding.toekangku1.ui.thread.ThreadSeekerActivity
import com.dicoding.toekangku1.ui.thread.ThreadWorkerActivity
import com.dicoding.toekangku1.ui.thread.mythreadsseeker.MyDetailThreadsSeeker
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeWorkerActivity : AppCompatActivity() {

    private var token = ""
    private var type = ""
    private lateinit var adapter : WorkerAdapter
    private val homeViewModel: HomeViewModel by viewModels { ViewModelFactory.getInstance(this) }
    private lateinit var binding: ActivityHomeWorkerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeWorkerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_home
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.menu_home -> {
                    true
                }
                R.id.menu_postingan -> {
                    val intent = Intent(applicationContext, ThreadWorkerActivity::class.java)
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

        binding.rvTerkaitHome.isNestedScrollingEnabled = false
        binding.rvTerkaitHome.isNestedScrollingEnabled = false

        setupView()
        observeSessionToken()
        homeViewModel.getSession(token, type)
        setupAction()
        relatedPost()

    }
    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun observeSessionToken() {
        homeViewModel.sessionData.observe(this, { (token, type) ->
            if (type == "Pelanggan") {
                val intent = Intent(this, HomeSeekerActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Assuming 'currentUser' is the user object you want to use
                val currentUser = UserData.users.first { it.type == "Pekerja" }
                setupViewForWorker(currentUser)
            }
        })
    }

    private fun setupViewForWorker(user: UserLocal) {
        binding.lokasiPengguna.text = user.locationCity
        binding.namaPengguna.text = user.name
        if (user.pictureUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(R.drawable.ic_user) // Replace with your default image
                .into(binding.profileWorker)
        } else {
            Glide.with(this)
                .load(user.pictureUrl)
                .placeholder(R.drawable.ic_user) // Replace with your default image
                .into(binding.profileWorker)
        }
    }

    private fun relatedPost() {
        val relatedPosts = SeekerData.threads // Assuming this is your list of related posts
        val relatedAdapter = RelatedWithPriceAdapter(relatedPosts)

        binding.rvTerkaitHome.layoutManager = LinearLayoutManager(this)
        binding.rvTerkaitHome.adapter = relatedAdapter
    }

    private fun setupAction(){
        binding.rvTerkaitHome.setOnClickListener {
            startActivity(Intent(this, MyDetailThreadsSeeker::class.java))
        }
    }
}