package com.example.database.data

import kotlinx.coroutines.flow.Flow

interface TrainingResultLocalDataSource {

    fun getAll(): Flow<List<TrainingResultEntity>>

    fun getLastTR(): Flow<TrainingResultEntity?>

    suspend fun delete(table: TrainingResultEntity)

    suspend fun insert(table: TrainingResultEntity)

    suspend fun deleteAll()

    suspend fun getTrainingResultById(id: Int): TrainingResultEntity?

}