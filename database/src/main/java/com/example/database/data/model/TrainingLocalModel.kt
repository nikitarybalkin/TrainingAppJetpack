package com.example.database.data.model

import androidx.room.ColumnInfo
import com.example.database.data.TrainingEntity

class TrainingLocalModel (
    val nameOfTrainingEntity: String,
    val exercises: List<String?>
)

fun TrainingEntity.mapToDomain() = TrainingLocalModel(
    nameOfTrainingEntity, exercises
)

fun TrainingLocalModel.mapToData() = TrainingEntity(
    nameOfTrainingEntity, exercises
)