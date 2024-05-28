package com.app.isanpablo.ui.login
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // Replace with your API base URL
    private const val BASE_URL = "http://192.168.1.180:8000/api/"


    // Create a Retrofit instance
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}