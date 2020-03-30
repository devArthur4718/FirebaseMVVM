package com.example.enftec.ui.home

import android.os.Bundle
import android.util.Log
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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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
        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("message")
        viewModel.itemList.observe(viewLifecycleOwner, Observer { topicList ->
            showTopics(topicList)
        })

        binding.btnSetValue.setOnClickListener {
            // Read from the database
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val value =
                        dataSnapshot.getValue(String::class.java)!!
                    Log.d(TAG, "Value is: $value")
                }

                override fun onCancelled(error: DatabaseError) { // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })
        }
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
