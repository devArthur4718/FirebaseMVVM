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
import com.example.enftec.core.MainActivity
import com.example.enftec.data.TopicAdapter
import com.example.enftec.databinding.HomeFragmentBinding
import com.example.enftec.net.models.Topics

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

        loginInDatabase();
        viewModel.getTopics().observe(viewLifecycleOwner, Observer { allTopics ->
            showLoading(true)
            showTopics(allTopics)
        })
    }

    private fun loginInDatabase() {
        viewModel.signInWithEmail("devarthur4718@gmail.com",
            "12345678",
            (activity as MainActivity))
    }

    private fun showTopics(topicList: List<Topics>) {
        val adapter = TopicAdapter()
        adapter.data = topicList
        binding.rvTopics.adapter = adapter
        showLoading(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.updateActionBarTitle("Tópicos")
    }
}
