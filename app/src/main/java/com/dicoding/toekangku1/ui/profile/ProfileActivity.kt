package com.dicoding.toekangku1.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.dataworkerlocal.UserData
import com.dicoding.toekangku1.data.dataworkerlocal.UserLocal
import com.dicoding.toekangku1.databinding.ActivityProfileBinding
import com.dicoding.toekangku1.ui.ViewModelFactory
import com.dicoding.toekangku1.ui.chat.ChatActivity
import com.dicoding.toekangku1.ui.home.HomeSeekerActivity
import com.dicoding.toekangku1.ui.thread.ThreadSeekerActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_profil
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.menu_home -> {
                    val intent = Intent(applicationContext, HomeSeekerActivity::class.java)
                    startActivity(intent)
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
                    true
                }
                else -> false
            }
        }

        setupView()
        setupAction()
        displayUserProfile(UserData.users.first())
    }

    fun setupView(){
        supportActionBar?.hide()
    }

    private fun displayUserProfile(user: UserLocal) {
        binding.profileName.text = user.name
        binding.profileRole.text = user.profesion
        binding.profileEmail.text = user.email
        binding.profileLocation.text = "${user.addressCity}, ${user.addressProvince}"

        Glide.with(this)
            .load(user.pictureUrl)
            .placeholder(R.drawable.ic_profile) // Use a default image if URL is null or empty
            .into(binding.profileImage)
    }

    private fun setupAction(){
        binding.tvTentangKami.setOnClickListener{
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

        binding.tvTransaksi.setOnClickListener{

        }

        binding.tvGantiPw.setOnClickListener{
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

        binding.tvBantuan.setOnClickListener{
            startActivity(Intent(this, HelpActivity::class.java))
        }

        binding.btnKeluar.setOnClickListener{
            //logout
        }

        binding.editProfile.setOnClickListener{
            startActivity(Intent(this, EditProfileActivity::class.java))
        }
    }
}