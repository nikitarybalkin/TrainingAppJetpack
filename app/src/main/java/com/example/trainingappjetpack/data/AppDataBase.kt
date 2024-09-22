package com.example.trainingappjetpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.data.TrainingDao
import com.example.database.data.TrainingEntity
import com.example.database.data.TrainingResultDao
import com.example.database.data.TrainingResultEntity
import com.example.database.data.utils.Converters

@Database(entities = [TrainingEntity::class, TrainingResultEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class AppDataBase : RoomDatabase() {
    abstract fun trainingDao() : TrainingDao
    abstract fun trainingResultDao() : TrainingResultDao
}