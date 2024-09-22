package com.example.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainingTable")
data class TrainingEntity(

    @PrimaryKey
    @ColumnInfo(name = "nameOfTrain")
    val nameOfTrainingEntity: String,
    @ColumnInfo("exercises")
    val exercises: List<String?>

    )
