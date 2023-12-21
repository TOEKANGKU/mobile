package com.dicoding.toekangku1.ui.home.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.dataworkerlocal.UserData
import com.dicoding.toekangku1.databinding.ActivityDetailWorkerBinding
import com.dicoding.toekangku1.ui.home.offeringJob.WorkerJobOfferActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailWorkerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailWorkerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWorkerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.btnAjukan.setOnClickListener {
            startActivity(Intent(this, WorkerJobOfferActivity::class.java))
        }
    }

    fun getDetail(){

        val workerId = intent.getIntExtra("WORKER_ID", -1)
        val workerDetail = UserData.users.find { it.id == workerId }
        workerDetail?.let { worker ->
            // Here you can set all the worker details to your views
            binding.workerName.text = worker.name
            binding.workerLocation.text = worker.addressCity
            binding.workerRating.text = String.format("5%") // Assuming 'rating' is a field in your UserLocal class
            binding.workerWork.text = worker.profesion

            // Set the worker image using Glide or another image loading library
            Glide.with(this)
                .load(worker.pictureUrl)
                .placeholder(R.drawable.ic_user) // Replace with your placeholder image
                .into(binding.workerImage)

            // Set other details like contact, career start, etc.
            binding.kontakDetail.text = worker.phone
            binding.domisiliDetail.text = "${worker.addressCity}, ${worker.addressProvince}"
            binding.mulaiBerkarirDetail.text = worker.startYear.toString()
            binding.tanggalLahirDetail.text = worker.birthDate
            // ... and so on for other details

        } ?: run {
            // If worker is not found, close the activity
            Toast.makeText(this, "Worker details not found.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}