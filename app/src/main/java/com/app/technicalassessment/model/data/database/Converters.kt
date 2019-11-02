package com.app.technicalassessment.model.data.database

import androidx.room.TypeConverter
import com.app.technicalassessment.model.data.Product
import com.app.technicalassessment.model.data.SalePrice
import com.google.gson.Gson
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {
    @TypeConverter fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter fun datestampToCalendar(value: Long): Calendar =
            Calendar.getInstance().apply { timeInMillis = value }

    @TypeConverter
    fun listToJson(value: List<Product>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Product>? {

        val objects = Gson().fromJson(value, Array<Product>::class.java) as Array<Product>
        val list = objects.toList()
        return list
    }

    @TypeConverter
    fun priceToJson(value: SalePrice?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun salePriceJsonToList(value: String):SalePrice? {
        val objects = Gson().fromJson(value, SalePrice::class.java) as SalePrice
        val obj = objects
        return obj
    }
}