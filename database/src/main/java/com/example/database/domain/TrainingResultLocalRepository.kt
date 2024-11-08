package com.example.database.domain

import com.example.database.data.model.TrainingResultLocalModel
import kotlinx.coroutines.flow.Flow

interface TrainingResultLocalRepository {
    fun getAll(): Flow<List<TrainingResultLocalModel>>

    fun getLastTR(): Flow<TrainingResultLocalModel?>

    suspend fun delete(table: TrainingResultLocalModel)

    suspend fun insert(table: TrainingResultLocalModel)

    suspend fun deleteAll()

    suspend fun getTrainingResultById(id: Int): TrainingResultLocalModel?
}