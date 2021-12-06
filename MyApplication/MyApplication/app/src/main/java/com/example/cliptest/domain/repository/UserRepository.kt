package com.example.cliptest.domain.repository

import com.example.cliptest.data.remote.RetrofitClient
import com.example.cliptest.data.remote.UserAPI
import com.example.cliptest.domain.model.ApiResponse
import kotlinx.coroutines.coroutineScope

object UserRepository {

    suspend fun getUser(): ApiResponse = coroutineScope {
        var res = ApiResponse()

        try {
            val retrofit = RetrofitClient().getRetrofitApi(RetrofitClient.BASEURL)
            val userService = retrofit.create(UserAPI::class.java)

            val result = userService.getInfo()

            if (result.isSuccessful) {
                res = result.body()!!
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        res
    }

}