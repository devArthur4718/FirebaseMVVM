package com.example.enftec.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.enftec.MainViewModel
import com.example.enftec.R
import com.example.enftec.databinding.HomeFragmentBinding

class Home : Fragment() {

    companion object{
        fun newInstance() = Home()
    }


    private lateinit var mainViewModel: MainViewModel
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


        setObservables()
        return binding.root
    }

    private fun setObservables() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
             mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw  Throwable("Invalid activity")
        mainViewModel.updateActionBarTitle("Tópicos")

    }

}
