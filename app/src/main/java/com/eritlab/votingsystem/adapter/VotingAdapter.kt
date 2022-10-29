package com.eritlab.votingsystem.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eritlab.votingsystem.databinding.RecyclerItemViewBinding

class VotingAdapter(
    private val list: MutableList<Any?>,
    private val recyclerViewInterface: RecyclerViewInterface
) :
    RecyclerView.Adapter<VotingAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: RecyclerItemViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.symbol.text = list[position] as String
        holder.binding.giveVote.setOnClickListener {
            recyclerViewInterface.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}