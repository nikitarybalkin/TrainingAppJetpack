package com.example.database.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrainingLocalDataSourceImpl @Inject constructor(private val trainingDao: TrainingDao): TrainingLocalDataSource {
    override fun getAll(): Flow<List<TrainingEntity>> {
        return trainingDao.getAll()
    }

    override fun getOneTrainExercises(nameOfTrain: String): Flow<List<String?>> {
        return trainingDao.getOneTrainExercises(nameOfTrain)
    }

    override suspend fun delete(table: TrainingEntity) {
        trainingDao.delete(table)
    }

    override suspend fun insertTable(table: TrainingEntity) {
        trainingDao.insertTable(table)
        Log.d("LOL", "datasource insert")
    }

    override suspend fun deleteAll() {
        trainingDao.deleteAll()
    }
}