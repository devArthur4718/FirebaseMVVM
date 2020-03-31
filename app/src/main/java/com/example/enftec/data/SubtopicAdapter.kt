package com.example.enftec.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.enftec.R
import com.example.enftec.databinding.ItemSubtopicBinding


//* Created by Arthur Gomes at 09/03/20 21:46 - contact me at devarthur4718@gmail.com.br
class SubtopicAdapter: RecyclerView.Adapter<SubtopicAdapter.ViewHolder>() {


    var content = listOf<String>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

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
        val content : String = content[0]
        holder.bind(topicItem, content)
    }

    class ViewHolder private constructor(val binding : ItemSubtopicBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : String,  content : String){
            binding.tvSubtopic.text = item
            binding.itemContainer.setOnClickListener {
                val bundle = bundleOf("contentPos" to content)
                itemView.findNavController().navigate(R.id.action_topicDetail_to_content2, bundle)
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