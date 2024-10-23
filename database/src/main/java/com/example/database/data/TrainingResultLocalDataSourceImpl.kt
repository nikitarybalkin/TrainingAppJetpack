package com.example.database.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrainingResultLocalDataSourceImpl @Inject constructor(private val trainingResultDao: TrainingResultDao): TrainingResultLocalDataSource {
    override fun getAll(): Flow<List<TrainingResultEntity>> {
        return trainingResultDao.getAll()
    }

    override fun getLastTR(): Flow<TrainingResultEntity?> {
        return trainingResultDao.getLastTR()
    }

    override suspend fun delete(table: TrainingResultEntity) {
        trainingResultDao.delete(table)
    }

    override suspend fun insert(table: TrainingResultEntity) {
        Log.d("LOL", "trainingResult datasource insert")
        trainingResultDao.insert(table)
    }

    override suspend fun deleteAll() {
        trainingResultDao.deleteAll()
    }

    override suspend fun getTrainingResultById(id: Int): TrainingResultEntity? {
        return trainingResultDao.getTrainingResultById(id)
    }
}