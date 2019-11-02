package com.app.technicalassessment.model.api

import com.app.technicalassessment.model.data.Category
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(".")
    fun getCategoriesWithProducts(): Call<List<Category>>
}