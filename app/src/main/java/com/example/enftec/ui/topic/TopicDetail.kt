package com.example.enftec.ui.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.enftec.R
import com.example.enftec.core.BaseFragment
import com.example.enftec.data.SubtopicAdapter
import com.example.enftec.databinding.TopicDetailFragmentBinding

class TopicDetail : BaseFragment() {

    companion object {
        fun newInstance() = TopicDetail()
    }

    private lateinit var viewModel: TopicDetailViewModel
    private lateinit var binding: TopicDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.topic_detail_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopicDetailViewModel::class.java)
        setObservables()
        var title =  arguments?.getString("topicArg")
        mainViewModel.updateActionBarTitle(title ?: "Detalhes")

    }

    private fun setObservables() {
        viewModel.itemList.observe(viewLifecycleOwner, Observer { subtopics ->
            showSubTopics(subtopics)
        })
    }

    private fun showSubTopics(subtopics: List<String>) {
        val adapter = SubtopicAdapter()
        adapter.data = subtopics
        binding.rvSubTopics.adapter = adapter
    }
}
