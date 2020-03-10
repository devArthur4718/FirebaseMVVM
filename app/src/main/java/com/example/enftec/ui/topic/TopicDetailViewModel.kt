package com.example.enftec.ui.topic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopicDetailViewModel : ViewModel() {

    private val _itemList = MutableLiveData<List<String>>()
    val itemList : LiveData<List<String>> get() = _itemList

    private val _navigateToContent = MutableLiveData<Boolean>()
    val navigateToContent : LiveData<Boolean> get() = _navigateToContent

    init {
        _itemList.postValue(listOf("Inspeção","Percussão", "Análise"))
    }

    fun navigateToContent(){
        _navigateToContent.value = true
    }

    fun doneNavigating(){
        _navigateToContent.value = false
    }
}
