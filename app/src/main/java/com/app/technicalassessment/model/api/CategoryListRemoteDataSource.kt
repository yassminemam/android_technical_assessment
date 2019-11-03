package com.app.technicalassessment.model.api

import javax.inject.Inject

class CategoryListRemoteDataSource @Inject
constructor(private val service: ApiInterface) {

    suspend fun fetchData() = service.getCategoriesWithProducts()
}