package com.example.enftec.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enftec.databinding.ItemTopicBinding

//* Created by Arthur Gomes at 09/03/20 21:46 - contact me at devarthur4718@gmail.com.br
class TopicAdapter: RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    var data = listOf<String>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicAdapter.ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: TopicAdapter.ViewHolder, position: Int) {
        val topicItem : String = data[position]
        holder.bind(topicItem)
    }

    class ViewHolder private constructor(val binding : ItemTopicBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : String){
            binding.tvTopic.text = item
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInfalter = LayoutInflater.from(parent.context)
                val binding = ItemTopicBinding.inflate(layoutInfalter,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}