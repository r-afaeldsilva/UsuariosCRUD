package com.example.usuarioscrud.services

import com.example.usuarioscrud.dto.DtoUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EndPoint {
    @POST("users")
    fun postDtoUser(@Body user: DtoUser): Call<DtoUser>
}