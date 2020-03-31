package com.example.enftec.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.enftec.R
import com.example.enftec.databinding.ContentFragmentBinding
import com.example.enftec.utils.BaseFragment



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

            var contentToLoad = arguments?.getString("contentPos")


            binding.webView.settings.apply {
                domStorageEnabled = true
                setAppCacheEnabled(true)
                javaScriptEnabled = true
                loadsImagesAutomatically = true
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }

            binding.webView.setWebChromeClient(object : WebChromeClient() {})

            binding.webView.loadData(content.replace("replaceContent", contentToLoad!!),"text/html","utf-8" )

//            try {
//                binding.webView.loadData(
//                    URLEncoder.encode(
//                        "<html><body><pre>${content.replace("replaceContent", contentToLoad!!)}</body></html>",
//                        "utf-8"
//                    ).replace("\\+", "%20"), "text/html", "utf-8"
//                )
//            } catch (uee: UnsupportedEncodingException) {
//                Log.e("webview", "", uee)
//            }

        })

    }

}
