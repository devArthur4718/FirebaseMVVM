package com.example.enftec.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.enftec.R
import com.example.enftec.core.BaseFragment
import com.example.enftec.data.TopicAdapter
import com.example.enftec.databinding.HomeFragmentBinding

class Home : BaseFragment() {

    companion object{
        fun newInstance() = Home()
    }


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        setObservables()
        return binding.root
    }

    private fun setObservables() {
        viewModel.itemList.observe(viewLifecycleOwner, Observer { topicList ->
            showTopics(topicList)
        })
    }

    private fun showTopics(topicList: List<String>) {
        val adapter = TopicAdapter()
        adapter.data = topicList
        binding.rvTopics.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.updateActionBarTitle("Tópicos")
    }
}
