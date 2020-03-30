package com.example.enftec.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.enftec.R
import com.example.enftec.databinding.ItemTopicBinding
import com.example.enftec.net.models.Topics

//* Created by Arthur Gomes at 09/03/20 21:46 - contact me at devarthur4718@gmail.com.br
class TopicAdapter: RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    var data = listOf<Topics>()
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
        val topicItem : Topics = data[position]
        holder.bind(topicItem)
    }

    class ViewHolder private constructor(val binding : ItemTopicBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Topics){
            binding.tvTopic.text = item.nome
            binding.itemContainer.setOnClickListener {
                val bundle = bundleOf("topicArg" to item.nome)
                itemView.findNavController().navigate(R.id.action_home2_to_topicDetail, bundle)
            }
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