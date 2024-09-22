package com.example.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainingResultTable")
data class TrainingResultEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id: Int = 0,
    @ColumnInfo(name = "nameOfTrain")
    val nameOfTrain: String,
    @ColumnInfo(name = "exercises")
    val exercises: List<String>,
    @ColumnInfo(name = "countInSet")
    val countInSet: List<Int>,
    @ColumnInfo(name = "countOfSets")
    val countOfSets: List<Int>,
    @ColumnInfo(name = "weights")
    val weights: List<Double>,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String

)
