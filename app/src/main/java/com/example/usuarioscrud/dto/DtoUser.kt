package com.example.usuarioscrud.dto

class DtoUser {
    var email: String? = null
    var id: Int? = null
    var name: String? = null
    var password: String? = null
    var phone: String? = null

constructor(email:String,nome:String,phone:String,senha:String){
    this.email = email
    this.name = nome
    this.phone = phone
    this.password = senha

}

}