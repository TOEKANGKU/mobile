package com.dicoding.toekangku1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.toekangku1.data.datathreadsforworker.Worker
import com.dicoding.toekangku1.databinding.ItemRelatedBinding

class RelatedAdapter(private val workers: List<Worker>) : RecyclerView.Adapter<RelatedAdapter.RelatedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val binding = ItemRelatedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RelatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        val worker = workers[position]
        holder.bind(worker)
    }

    override fun getItemCount() = workers.size

    class RelatedViewHolder(private val binding: ItemRelatedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(worker: Worker) {
            binding.apply {
                postTitle.text = worker.title
                postRating.text = worker.professions // Assuming this is where you want to show professions
                postDate.text = worker.createdAt // Format this date as needed

                // If you have a category icon to show based on the worker's type or profession, set it here
                // Example: postCategoryIcon.setImageResource(...)
            }
        }
    }
}