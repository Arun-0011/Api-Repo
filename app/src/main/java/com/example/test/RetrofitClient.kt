package com.example.test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api : APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.gpaywallet.io/index.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}