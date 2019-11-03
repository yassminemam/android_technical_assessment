package com.app.technicalassessment

import com.app.technicalassessment.model.api.ApiInterface
import com.app.technicalassessment.model.api.CategoryListRemoteDataSource
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.awaitResponse

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Test
    suspend fun fetchData_isSuccessful() {
        val service: ApiInterface = Mockito.spy(ApiInterface::class.java)
        val dataSource = CategoryListRemoteDataSource(service)
        assert(dataSource.fetchData().awaitResponse().isSuccessful)
    }
}
