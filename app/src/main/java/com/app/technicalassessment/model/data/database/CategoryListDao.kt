package com.app.technicalassessment.model.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.technicalassessment.model.data.Category

/**
 * The Data Access Object for the LegoTheme class.
 */
@Dao
interface CategoryListDao {

    @Query("SELECT * FROM categoryList ORDER BY id DESC")
    fun getLegoThemes(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Category>)
}
