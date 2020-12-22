package com.example.usuarioscrud.dto

class DtoLogin {
    var email: String? = null
    var password: String? = null
    var token: String? = null

    constructor(email:String,senha:String){
        this.email = email
        this.password = senha

    }
}