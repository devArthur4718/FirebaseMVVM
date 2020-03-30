package com.example.enftec.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

//* Created by Arthur Gomes at 09/03/20 22:55 - contact me at devarthur4718@gmail.com.br

open class BaseFragment : Fragment(){

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
}