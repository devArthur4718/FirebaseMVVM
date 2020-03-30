package com.example.enftec.net.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enftec.core.MainActivity
import com.example.enftec.net.models.Users


class AuthViewModel : ViewModel(){

    var authRepository = FirebaseAuthRepository()
    var authenticatedUserLiveData: LiveData<Users>? = null

    fun signInWithEmail(email : String , password : String, activity : MainActivity){
        authenticatedUserLiveData = authRepository.logInWithEmailAndPassword(email,password, activity)
    }

}
