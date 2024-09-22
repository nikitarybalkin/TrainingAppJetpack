package com.example.database.data

import kotlinx.coroutines.flow.Flow

interface TrainingLocalDataSource {

    fun getAll(): Flow<List<TrainingEntity>>

    fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>>

    suspend fun delete(table: TrainingEntity)

    suspend fun insertTable(table: TrainingEntity)

    suspend fun deleteAll()
}