package com.example.database.domain

import com.example.database.data.model.TrainingResultLocalModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrainingResultLocalUseCase @Inject constructor(private val trainingResultLocalRepository: TrainingResultLocalRepository) {

    fun getAll(): Flow<List<TrainingResultLocalModel>> {
        return trainingResultLocalRepository.getAll()
    }

    fun getLastTR(): Flow<List<TrainingResultLocalModel?>> {
        return trainingResultLocalRepository.getLastTR()
    }

    suspend fun delete(table: TrainingResultLocalModel) {
        trainingResultLocalRepository.delete(table)
    }

    suspend fun insert(table: TrainingResultLocalModel) {
        trainingResultLocalRepository.insert(table)
    }

    suspend fun deleteAll() {
        trainingResultLocalRepository.deleteAll()
    }

}