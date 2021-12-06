package com.example.cliptest.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object{
        val BASEURL = "https://randomuser.me/"
    }

    private fun getDefaultOkhttpClient(): OkHttpClient{
        val okBuilder = OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

        return okBuilder
    }

    fun getRetrofitApi(baseUrl: String, okBuilder: OkHttpClient = getDefaultOkhttpClient()): Retrofit{
        var retrofitPrueba = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okBuilder)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofitPrueba
    }

}