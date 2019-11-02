package com.app.technicalassessment.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient



object RetrofitInstance {
    val BASE_URL = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/" //development
    var client = OkHttpClient.Builder()
        .build()

    private var retrofit: Retrofit? = null
    fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}