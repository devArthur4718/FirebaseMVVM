package com.example.enftec.net.models

data class Users (var uid : String = "",
                  var name : String = "",
                  var email : String = ""
){

    constructor() : this("", "", "" )



}