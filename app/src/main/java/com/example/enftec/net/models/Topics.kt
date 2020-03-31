package com.example.enftec.net.models



data class Topics(
    var nome : String = "",
    var conteudos : List<String> = emptyList(),
    var subtopicos :  List<String> = emptyList()
    )

