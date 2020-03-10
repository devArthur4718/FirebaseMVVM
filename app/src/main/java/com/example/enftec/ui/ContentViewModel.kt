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
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Styling Images</h2>\n" +
                "<p>The image below has the width attribute set to 128 pixels, but the stylesheet overrides it, and sets the width to 100%.</p>\n" +
                "<img src=\"html5.gif\" alt=\"HTML5 Icon\" width=\"128\" height=\"128\">\n" +
                "\n" +
                "<p>The image below uses the style attribute, where the width is set to 128 pixels which overrides the stylesheet:</p>\n" +
                "<img src=\"https://images.theconversation.com/files/304957/original/file-20191203-66986-im7o5.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=926&fit=clip\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\">\n" +
                "\n" +
                "</body>\n" +
                "</html>\n")

    }

}
