package com.dicoding.toekangku1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.toekangku1.data.datathreadsforworker.Worker
import com.dicoding.toekangku1.databinding.ItemRelatedWithPriceBinding

class RelatedWithPriceAdapter(private val workers: List<Worker>) : RecyclerView.Adapter<RelatedWithPriceAdapter.RelatedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val binding = ItemRelatedWithPriceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RelatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        val worker = workers[position]
        holder.bind(worker)
    }

    override fun getItemCount() = workers.size

    class RelatedViewHolder(private val binding: ItemRelatedWithPriceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(worker: Worker) {
            binding.apply {
                postTitle.text = worker.title
                namePrice.text = "${worker.userId} (${worker.userId})"
                tvPrice.text = "Rp. ${worker.payment}/ ${worker.paymentType}"
                tvWork.text = worker.professions
                tvLocation.text = "${worker.locationCity}, ${worker.locationProvince}"
            }
        }
    }
}