package com.rodionov.osport.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodionov.osport.data.database.entities.CompetitionShortRemoteKeyEntity

@Dao
interface CompetitionShortRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<CompetitionShortRemoteKeyEntity>)

    @Query("SELECT * FROM competitions_short_remote_keys WHERE id = :competitionId")
    suspend fun getCompetitionShortRemoteKey(competitionId: String): CompetitionShortRemoteKeyEntity?

    @Query("DELETE FROM competitions_short_remote_keys")
    suspend fun clearAll()

}