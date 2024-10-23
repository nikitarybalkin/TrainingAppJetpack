package com.example.database.utils

import com.example.database.data.model.TrainingLocalModel
import com.example.database.data.model.TrainingResultLocalModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertersArguments {
    private val gson = Gson()

    fun fromTrainingLocalModel(trainingLocalModel: TrainingLocalModel): String {
        return gson.toJson(trainingLocalModel)
    }

    fun toTrainingLocalModel(trainingString: String): TrainingLocalModel {
        val trainingType = object : TypeToken<TrainingLocalModel>() {}.type
        return gson.fromJson(trainingString, trainingType)
    }

    fun fromTrainingResultLocalModel(trainingResultLocalModel: TrainingResultLocalModel): String {
        return gson.toJson(trainingResultLocalModel)
    }

    fun toTrainingResultLocalModel(trainingResultString: String): TrainingResultLocalModel {
        val trainingResultType = object : TypeToken<TrainingResultLocalModel>() {}.type
        return gson.fromJson(trainingResultString, trainingResultType)
    }
}