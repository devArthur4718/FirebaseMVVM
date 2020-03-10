package com.example.enftec.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.enftec.R
import com.example.enftec.core.BaseFragment
import com.example.enftec.databinding.ContentFragmentBinding

class Content : BaseFragment() {

    companion object {
        fun newInstance() = Content()
    }

    private lateinit var viewModel: ContentViewModel
    private lateinit var binding : ContentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.content_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContentViewModel::class.java)
        mainViewModel.updateActionBarTitle("Conteúdo")
        setObservables()
    }

    private fun setObservables() {
        viewModel.contentBody.observe(viewLifecycleOwner, Observer { content ->
            binding.webView.settings.apply {
                domStorageEnabled = true
                setAppCacheEnabled(true)
                loadsImagesAutomatically = true
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
            binding.webView.loadData(content, "text/html", "UTF-8")
        })

    }

}
