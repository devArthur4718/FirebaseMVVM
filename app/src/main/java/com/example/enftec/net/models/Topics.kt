package com.example.enftec.net.models

data class Topics(var nome : String,
                  var status : Boolean) {
    constructor() : this("", false)
}