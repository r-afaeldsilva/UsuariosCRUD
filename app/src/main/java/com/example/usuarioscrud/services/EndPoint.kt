package com.example.usuarioscrud.services

import com.example.usuarioscrud.dto.DtoLogin
import com.example.usuarioscrud.dto.DtoUser
import retrofit2.Call
import retrofit2.http.*


interface EndPoint {
    @POST("users")
    fun postDtoUser(@Body user: DtoUser): Call<DtoUser>

    @POST("auth/login")
    fun postDtoLogin(@Body login: DtoLogin): Call<DtoLogin>

    @GET("users")
    fun getDtoListUser(@Header("Authorization") authorization: String?): Call<List<DtoUser?>?>?

    @PUT("users/{id}")
    fun putDtoUser(@Body user: DtoUser, @Path("id") id: Int, @Header("Authorization") authorization: String?): Call<Void>
}