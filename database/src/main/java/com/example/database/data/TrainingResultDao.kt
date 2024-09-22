package com.example.database.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingResultDao {

    @Query("SELECT * FROM trainingResultTable")
    fun getAll(): Flow<List<TrainingResultEntity>>

    @Query("SELECT * \n" +
            "    FROM trainingResultTable\n" +
            "    WHERE id = (SELECT MAX(id) FROM trainingResultTable);")
    fun getLastTR(): Flow<List<TrainingResultEntity?>>

    @Delete
    suspend fun delete(table: TrainingResultEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table: TrainingResultEntity)

    @Query("DELETE FROM trainingResultTable")
    suspend fun deleteAll()

}