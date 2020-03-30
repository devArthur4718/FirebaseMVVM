package com.example.enftec.net

import androidx.lifecycle.MutableLiveData
import com.example.enftec.net.models.Users
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthRepository {

    var auth = FirebaseAuth.getInstance()
    var userLiveData : MutableLiveData<Users> = MutableLiveData()

}