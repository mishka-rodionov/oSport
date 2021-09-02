package com.rodionov.osport.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodionov.osport.data.database.entities.CompetitionShortEntity

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCompetitionShort(competitionShorts: List<CompetitionShortEntity>)

    @Query("SELECT * FROM competitions_short WHERE id = :competitionShortId")
    suspend fun getCompetitionShort(competitionShortId: String): CompetitionShortEntity?

    @Query("DELETE FROM competitions_short")
    suspend fun clearAllCompetitionShort()

}