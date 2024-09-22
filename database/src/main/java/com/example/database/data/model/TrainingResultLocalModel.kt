package com.example.database.data.model

import androidx.room.ColumnInfo
import com.example.database.data.TrainingResultEntity

class TrainingResultLocalModel (
    val id: Int = 0,
    val nameOfTrain: String,
    val exercises: List<String>,
    val countInSet: List<Int>,
    val countOfSets: List<Int>,
    val weights: List<Double>,
    val date: String,
    val time: String
)

fun TrainingResultEntity.mapToDomain() = TrainingResultLocalModel (
    id, nameOfTrain, exercises, countInSet, countOfSets, weights, date, time
)

fun TrainingResultLocalModel.mapToData() = TrainingResultEntity (
    id, nameOfTrain, exercises, countInSet, countOfSets, weights, date, time
)