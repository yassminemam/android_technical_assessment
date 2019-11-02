package com.app.technicalassessment.model.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.app.technicalassessment.model.data.Category
import kotlinx.coroutines.Dispatchers

fun <T> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> List<Category>,
    saveCallResult: suspend (List<Category>) -> Unit
): LiveData<T> =
    liveData(Dispatchers.IO) {
        val source: LiveData<T> = databaseQuery.invoke().map { it }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        saveCallResult(responseStatus)
    }