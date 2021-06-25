package com.rodionov.osport.data.database.entities

import androidx.room.*
import com.rodionov.osport.data.database.converters.CommonConverters
import java.util.*

@Entity(tableName = "user")
@TypeConverters(CommonConverters::class)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "first_name")
    val firstName: String? = null,
    @ColumnInfo(name = "second_name")
    val middleName: String? = null,
    @ColumnInfo(name = "last_name")
    val lastName: String? = null,
    @ColumnInfo(name = "phone_country_prefix")
    val phoneCountryPrefix: String? = null,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null,
    @ColumnInfo(name = "email")
    val email: String? = null,
    @ColumnInfo(name = "birth_date")
    val birthDate: Date? = null
)
