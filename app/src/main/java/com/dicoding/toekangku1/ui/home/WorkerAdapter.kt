package com.dicoding.toekangku1.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.toekangku1.R
import com.dicoding.toekangku1.data.dataworkerlocal.UserLocal
import com.dicoding.toekangku1.databinding.ItemWorkerBinding

class WorkerAdapter(private val workers: List<UserLocal>) : RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

    var onItemClick: ((UserLocal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val binding = ItemWorkerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val worker = workers[position]
        holder.bind(worker)
        Log.d("ceksize", workers.size.toString())
    }

    override fun getItemCount() = workers.size

    class WorkerViewHolder(private val binding: ItemWorkerBinding) : RecyclerView.ViewHolder(binding.root) {
        var onItemClick: ((UserLocal) -> Unit)? = null
        fun bind(worker: UserLocal) {
            binding.root.setOnClickListener {
                onItemClick?.invoke(worker)
            }
            binding.apply {
                // Assume you have a TextView for the worker's name and profession.
                workerName.text = worker.name
                workerWork.text = worker.profesion

                // Assuming you have a TextView for the worker's location.
                workerLocation.text = "${worker.addressCity}, ${worker.addressProvince}"

                // Assuming you have an ImageView to display the worker's profile picture.
                if (worker.pictureUrl.isNullOrEmpty()) {
                    workerImage.setImageResource(R.drawable.ic_user)
                } else {
                    Glide.with(workerImage.context)
                        .load(worker.pictureUrl)
                        .placeholder(R.drawable.ic_user) // Replace with a default image resource
                        .into(workerImage)
                }

                Log.d("cekWorker", worker.toString())

                // Set an OnClickListener if you need to handle item clicks
                root.setOnClickListener {
                    // Handle the click event for the worker item
                }
            }
        }
    }
}