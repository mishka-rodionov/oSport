package com.rodionov.osport.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodionov.osport.data.database.entities.CompetitionShortEntity
import com.rodionov.osport.domain.model.CompetitionShort

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCompetitionShort(competitionShorts: List<CompetitionShortEntity>)

    @Query("SELECT * FROM competitions_short WHERE id = :competitionShortId")
    suspend fun getCompetitionShort(competitionShortId: String): CompetitionShortEntity?

    @Query("SELECT * FROM competitions_short")
    fun getCompetitionShortPagingSource(): PagingSource<Int, CompetitionShort>

    @Query("DELETE FROM competitions_short")
    suspend fun clearAllCompetitionShort()

}