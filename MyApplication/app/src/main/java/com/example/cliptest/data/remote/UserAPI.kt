package com.example.cliptest.data.remote

import com.example.cliptest.domain.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserAPI {
    @Headers(
        "Content-Type: application/json")
    @GET("api/?results=20")
    suspend fun getInfo(): Response<ApiResponse>
}
