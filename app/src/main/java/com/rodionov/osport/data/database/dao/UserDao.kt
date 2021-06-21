package com.rodionov.osport.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodionov.osport.data.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setUser(userEntity: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: String): UserEntity

    @Query("DELETE FROM user")
    fun clearAll()

}