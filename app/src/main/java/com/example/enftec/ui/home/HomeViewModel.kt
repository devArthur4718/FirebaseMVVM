package com.example.enftec.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _itemList = MutableLiveData<List<String>>()
    val itemList : LiveData<List<String>> get() = _itemList

    init {
        _itemList.postValue(listOf<String>("Cabeça","Pescoço", "Torço","Braços","Pernas", "Pés"))
    }



}
