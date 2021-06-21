package com.rodionov.osport.data.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.util.*

open class CommonConverters {

    @TypeConverter
    open fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    open fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    open fun toListString(strings: List<String>) = Gson().toJson(strings)

    @TypeConverter
    open fun fromListString(strings: String) = Gson().fromJson(strings, Array<String>::class.java).toList()

}