package com.example.enftec.net.topics

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepository {

    //Class used to return every collection for our application.
    var firestoreDB = FirebaseFirestore.getInstance()

    fun getTopics () : CollectionReference {
        var collectionReference = firestoreDB.collection(COLLECTION_TOPICS)
        return collectionReference
    }

    companion object{
        const val COLLECTION_TOPICS = "topics"
    }

}