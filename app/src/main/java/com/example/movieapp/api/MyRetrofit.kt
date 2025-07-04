package com.example.movieapp.api

import com.example.movieapp.const.Constants.Companion.API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }


}