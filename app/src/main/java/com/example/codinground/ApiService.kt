package com.example.codinground.api

import com.example.codinground.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<UserResponse>

}