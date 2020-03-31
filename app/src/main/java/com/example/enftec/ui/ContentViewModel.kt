package com.example.enftec.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentViewModel : ViewModel() {

    private val _contentBody = MutableLiveData<String>()
    val contentBody : LiveData<String> get() = _contentBody

    init {
        _contentBody.postValue("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "/* This stylesheet sets the width of all images to 100%: */\n" +
                "img {\n" +
                "  width: 100%;\n" +
                "}\n" +
                "iframe {\n" +
                "  width: 100%;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "replaceContent" +
                "</body>\n" +
                "</html>\n")

    }

}
