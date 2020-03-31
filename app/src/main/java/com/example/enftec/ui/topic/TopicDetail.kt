package com.example.enftec.ui.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.enftec.R
import com.example.enftec.utils.BaseFragment
import com.example.enftec.data.SubtopicAdapter
import com.example.enftec.databinding.TopicDetailFragmentBinding
import com.example.enftec.utils.Contanstutils
import java.util.ArrayList

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
        var title =  arguments?.getString(Contanstutils.ARG_TOPIC)
        var subTopicsList = arguments?.getStringArrayList(Contanstutils.ARG_SUBTOPIC)
        viewModel.addSubtopiclist(subTopicsList)
        mainViewModel.updateActionBarTitle(title ?: "Detalhes")
        setObservables()

    }

    private fun setObservables() {
        viewModel.itemList.observe(viewLifecycleOwner, Observer { subtopics ->
            var contentList = arguments?.getStringArrayList(Contanstutils.ARG_CONTENT)
            showSubTopics(subtopics,contentList)
        })
    }

    private fun showSubTopics(subtopics: List<String>, contentList: ArrayList<String>?) {
        val adapter = SubtopicAdapter()
        adapter.data = subtopics
        contentList?.let { adapter.content = it }
        binding.rvSubTopics.adapter = adapter
    }
}
