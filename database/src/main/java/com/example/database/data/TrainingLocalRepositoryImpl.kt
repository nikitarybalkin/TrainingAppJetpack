package com.example.database.data

import com.example.database.data.model.TrainingLocalModel
import com.example.database.data.model.mapToData
import com.example.database.data.model.mapToDomain
import com.example.database.domain.TrainingLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrainingLocalRepositoryImpl @Inject constructor(private val trainingLocalDataSource: TrainingLocalDataSource): TrainingLocalRepository {
    override fun getAll(): Flow<List<TrainingLocalModel>> {
        return trainingLocalDataSource.getAll().map { list -> list.map { it.mapToDomain() } }
    }

    override fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>> {
        return  trainingLocalDataSource.getOneTrainExercises(nameOfTrain)
    }

    override suspend fun delete(table: TrainingLocalModel) {
        trainingLocalDataSource.delete(table.mapToData())
    }

    override suspend fun insertTable(table: TrainingLocalModel) {
        trainingLocalDataSource.insertTable(table.mapToData())
    }

    override suspend fun deleteAll() {
        trainingLocalDataSource.deleteAll()
    }

}