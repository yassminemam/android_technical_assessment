package com.app.technicalassessment.viewmodel

import com.app.technicalassessment.model.api.CategoryListRemoteDataSource
import com.app.technicalassessment.model.api.resultLiveData
import com.app.technicalassessment.model.data.database.CategoryListDao
import retrofit2.awaitResponse
import javax.inject.Inject

class CategoryListRepo @Inject constructor(private val dao: CategoryListDao,
                                           private val remoteSource: CategoryListRemoteDataSource) {

    val items = resultLiveData(
        databaseQuery = { dao.getLegoThemes() },
        networkCall = { remoteSource.fetchData().awaitResponse().body()!!},
        saveCallResult = { dao.insertAll(it)})
}