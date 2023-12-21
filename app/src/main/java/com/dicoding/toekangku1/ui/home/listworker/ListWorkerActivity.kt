package com.dicoding.toekangku1.ui.home.listworker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.dataworkerlocal.UserData
import com.dicoding.toekangku1.databinding.ActivityListWorkerBinding
import com.dicoding.toekangku1.ui.home.WorkerAdapter

class ListWorkerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListWorkerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListWorkerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupUser()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupUser(){
        // Filter the users list for workers of type "Pekerja"
        val workerRecommendations = UserData.users.filter { it.type == "Pekerja" }

        // Create and set the adapter for the RecyclerView
        val adapter = WorkerAdapter(workerRecommendations)
        binding.rvListworker.adapter = adapter
    }

    private fun setupAction(){

    }


}

