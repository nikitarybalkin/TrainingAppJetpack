package com.example.database.data

import com.example.database.data.model.TrainingResultLocalModel
import com.example.database.data.model.mapToData
import com.example.database.data.model.mapToDomain
import com.example.database.domain.TrainingResultLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrainingResultLocalRepositoryImpl @Inject constructor(private val trainingResultLocalDataSource: TrainingResultLocalDataSource): TrainingResultLocalRepository {
    override fun getAll(): Flow<List<TrainingResultLocalModel>> {
        return trainingResultLocalDataSource.getAll().map { list -> list.map { it.mapToDomain() } }
    }

    override fun getLastTR(): Flow<TrainingResultLocalModel?> {
        return trainingResultLocalDataSource.getLastTR().map { it?.mapToDomain() }
    }

    override suspend fun delete(table: TrainingResultLocalModel) {
        trainingResultLocalDataSource.delete(table.mapToData())
    }

    override suspend fun insert(table: TrainingResultLocalModel) {
        trainingResultLocalDataSource.insert(table.mapToData())
    }

    override suspend fun deleteAll() {
        trainingResultLocalDataSource.deleteAll()
    }

    override suspend fun getTrainingResultById(id: Int): TrainingResultLocalModel? {
        return trainingResultLocalDataSource.getTrainingResultById(id)?.mapToDomain()
    }

}