package com.example.database.domain

import com.example.database.data.model.TrainingLocalModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrainingLocalUseCase @Inject constructor(private val trainingLocalRepository: TrainingLocalRepository) {
    fun getAll(): Flow<List<TrainingLocalModel>> {
        return trainingLocalRepository.getAll()
    }

    fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>> {
        return trainingLocalRepository.getOneTrainExercises(nameOfTrain)
    }

    suspend fun delete(table: TrainingLocalModel) {
        trainingLocalRepository.delete(table)
    }

    suspend fun insertTable(table: TrainingLocalModel) {
        trainingLocalRepository.insertTable(table)
    }

    suspend fun deleteAll() {
        trainingLocalRepository.deleteAll()
    }
}