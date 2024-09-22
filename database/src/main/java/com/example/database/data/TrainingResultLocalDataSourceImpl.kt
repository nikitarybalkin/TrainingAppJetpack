package com.example.database.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrainingResultLocalDataSourceImpl @Inject constructor(private val trainingResultDao: TrainingResultDao): TrainingResultLocalDataSource {
    override fun getAll(): Flow<List<TrainingResultEntity>> {
        return trainingResultDao.getAll()
    }

    override fun getLastTR(): Flow<List<TrainingResultEntity?>> {
        return trainingResultDao.getLastTR()
    }

    override suspend fun delete(table: TrainingResultEntity) {
        trainingResultDao.delete(table)
    }

    override suspend fun insert(table: TrainingResultEntity) {
        trainingResultDao.insert(table)
    }

    override suspend fun deleteAll() {
        trainingResultDao.deleteAll()
    }
}