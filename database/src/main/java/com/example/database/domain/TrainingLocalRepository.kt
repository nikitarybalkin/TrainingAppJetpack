package com.example.database.domain

import com.example.database.data.model.TrainingLocalModel
import kotlinx.coroutines.flow.Flow

interface TrainingLocalRepository {
    fun getAll(): Flow<List<TrainingLocalModel>>

    fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>>

    suspend fun delete(table: TrainingLocalModel)

    suspend fun insertTable(table: TrainingLocalModel)

    suspend fun deleteAll()

}