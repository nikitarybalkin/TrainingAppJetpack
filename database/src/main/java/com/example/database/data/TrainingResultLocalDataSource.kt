package com.example.database.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TrainingResultLocalDataSource {

    fun getAll(): Flow<List<TrainingResultEntity>>

    fun getLastTR(): Flow<List<TrainingResultEntity?>>

    suspend fun delete(table: TrainingResultEntity)

    suspend fun insert(table: TrainingResultEntity)

    suspend fun deleteAll()

}