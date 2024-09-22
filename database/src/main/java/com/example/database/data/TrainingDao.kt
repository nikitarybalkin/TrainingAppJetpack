package com.example.database.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingDao {

    @Query("SELECT * FROM trainingTable")
    fun getAll(): Flow<List<TrainingEntity>>

    @Query("SELECT exercises FROM trainingTable WHERE nameOfTrain = :nameOfTrain")
    fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>>

    @Delete
    suspend fun delete(table: TrainingEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTable(table: TrainingEntity)

    @Query("DELETE FROM trainingTable")
    suspend fun deleteAll()

}