package com.app.technicalassessment.model.api

import com.app.technicalassessment.model.data.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CategoryListRemoteDataSource @Inject
constructor(private val service: ApiInterface) {

    suspend fun fetchData() = service.getCategoriesWithProducts()
}