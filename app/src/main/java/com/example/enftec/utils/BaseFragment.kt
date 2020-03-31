package com.example.enftec.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.enftec.core.MainViewModel
import com.example.enftec.ui.dialog.LoadingDialog

//* Created by Arthur Gomes at 09/03/20 22:55 - contact me at devarthur4718@gmail.com.br

open class BaseFragment : Fragment(){
    private val loadingDialog by lazy { context?.let { LoadingDialog(it) } }

    lateinit var mainViewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw  Throwable("Invalid activity")

    }

    companion object{
        const val TAG = "debugDevArthur"
    }

    fun showLoading(show: Boolean) {
        if (show) onStartLoading()
        else onStopLoading()
    }

    fun onStartLoading() {
        if (isAdded) loadingDialog?.show()
    }

    fun onStopLoading() {
        if (isAdded) loadingDialog?.dismiss()
    }
}