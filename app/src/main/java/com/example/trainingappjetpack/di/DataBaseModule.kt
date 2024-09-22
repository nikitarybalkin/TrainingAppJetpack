package com.example.trainingappjetpack.di

import android.content.Context
import androidx.room.Room
import com.example.database.data.TrainingDao
import com.example.database.data.TrainingLocalDataSource
import com.example.database.data.TrainingLocalDataSourceImpl
import com.example.database.data.TrainingLocalRepositoryImpl
import com.example.database.data.TrainingResultDao
import com.example.database.data.TrainingResultLocalDataSource
import com.example.database.data.TrainingResultLocalDataSourceImpl
import com.example.database.data.TrainingResultLocalRepositoryImpl
import com.example.database.domain.TrainingLocalRepository
import com.example.database.domain.TrainingResultLocalRepository
import com.example.trainingappjetpack.data.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {
    @Provides
    fun provideDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "db")
            .fallbackToDestructiveMigration().build()
    }
    @Provides
    fun provideTrainingDao(db: AppDataBase): TrainingDao {
        return db.trainingDao()
    }
    @Provides
    fun provideTrainingRepository(trainingLocalRepositoryImpl: TrainingLocalRepositoryImpl): TrainingLocalRepository {
        return trainingLocalRepositoryImpl
    }
    @Provides
    fun provideTrainingDataSource(trainingLocalDataSourceImpl: TrainingLocalDataSourceImpl): TrainingLocalDataSource {
        return trainingLocalDataSourceImpl
    }
    @Provides
    fun provideTrainingResultDao(db: AppDataBase): TrainingResultDao {
        return db.trainingResultDao()
    }
    @Provides
    fun provideTrainingResultRepository(trainingResultLocalRepositoryImpl: TrainingResultLocalRepositoryImpl): TrainingResultLocalRepository {
        return trainingResultLocalRepositoryImpl
    }
    @Provides
    fun provideTrainingResultDataSource(trainingResultLocalDataSourceImpl: TrainingResultLocalDataSourceImpl): TrainingResultLocalDataSource {
        return trainingResultLocalDataSourceImpl
    }
}