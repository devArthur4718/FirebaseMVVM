package com.example.enftec.net.topics

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enftec.net.models.Topics
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot

class FirestoreViewModel : ViewModel(){

    var firebaseRepository = FirestoreRepository()

    var allTopics : MutableLiveData<List<Topics>> = MutableLiveData()

    fun getTopics() : LiveData<List<Topics>> {
        firebaseRepository.getTopics().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.d(TAG, "Listen failed.", e)
                allTopics.value = null
                return@EventListener
            }

            var topicList : MutableList<Topics> = mutableListOf()
            for (doc in value!!) {
                var item = doc.toObject(Topics::class.java)
                topicList.add(item)
            }
            allTopics.value = topicList
        })
        return allTopics

    }

    companion object{
        const val TAG = "database"
    }
}