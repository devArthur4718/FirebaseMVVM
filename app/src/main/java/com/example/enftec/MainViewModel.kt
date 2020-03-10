package com.example.enftec

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//* Created by Arthur Gomes at 09/03/20 21:24 - contact me at devarthur4718@gmail.com.br
class MainViewModel : ViewModel(){

    private val _title = MutableLiveData<String>()
    val title : LiveData<String> get() = _title

    fun updateActionBarTitle(title : String) {
        _title.postValue(title)
    }
}