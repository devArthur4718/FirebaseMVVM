package com.example.enftec.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.enftec.R
import com.example.enftec.databinding.ItemSubtopicBinding


//* Created by Arthur Gomes at 09/03/20 21:46 - contact me at devarthur4718@gmail.com.br
class SubtopicAdapter: RecyclerView.Adapter<SubtopicAdapter.ViewHolder>() {

    var data = listOf<String>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtopicAdapter.ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: SubtopicAdapter.ViewHolder, position: Int) {
        val topicItem : String = data[position]
        holder.bind(topicItem)
    }

    class ViewHolder private constructor(val binding : ItemSubtopicBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : String){
            binding.tvSubtopic.text = item
            binding.itemContainer.setOnClickListener {
                itemView.findNavController().navigate(R.id.action_topicDetail_to_content2)
            }
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInfalter = LayoutInflater.from(parent.context)
                val binding = ItemSubtopicBinding.inflate(layoutInfalter,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}