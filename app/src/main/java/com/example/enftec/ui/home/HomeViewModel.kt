package com.example.enftec.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enftec.core.MainActivity
import com.example.enftec.net.auth.FirebaseAuthRepository
import com.example.enftec.net.models.Subtopics
import com.example.enftec.net.models.Topics
import com.example.enftec.net.models.Users
import com.example.enftec.net.topics.FirestoreRepository
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot

class HomeViewModel : ViewModel() {

    var firebaseRepository = FirestoreRepository()
    var authRepository = FirebaseAuthRepository()


    var allTopics : MutableLiveData<List<Topics>> = MutableLiveData()
    var allsubTopics : MutableLiveData<List<Subtopics>> = MutableLiveData()

    private val _loadingData = MutableLiveData<Boolean>()
    val loadingData : LiveData<Boolean> get() = _loadingData

    fun getTopics() : LiveData<List<Topics>> {
        _loadingData.value = true
        firebaseRepository.getTopics().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.d(TAG, "Listen failed.", e)
                allTopics.value = null
                _loadingData.value = false
                return@EventListener
            }

            var topicList : MutableList<Topics> = mutableListOf()
            for (doc in value!!) {
                var item = doc.toObject(Topics::class.java)
                topicList.add(item)
            }
            allTopics.value = topicList
        })
        _loadingData.value = false
        return allTopics

    }


    var authenticatedUserLiveData: LiveData<Users>? = null

    fun signInWithEmail(email : String , password : String, activity : MainActivity){
        authenticatedUserLiveData = authRepository.logInWithEmailAndPassword(email,password, activity)
    }

    companion object{
        const val TAG = "database"
    }


}
