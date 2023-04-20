package com.example.test

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("api/authentication/alltoken/7150/1")
    suspend fun fetchTokenDetails(): Response<TokenResponse>
}