package com.feature.creation.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingLocalModel
import com.example.database.domain.TrainingLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateTrainingViewModel @Inject constructor(
    private val trainingLocalUseCase: TrainingLocalUseCase
): ViewModel() {
    var nameOfExercise = ""
    var nameOfTrain = ""
    val listOfExercises: MutableList<String> = mutableListOf()
    fun sendToDatabase() {
        viewModelScope.launch {
            Log.d("LOL", "vm ins = ${listOfExercises[0]}")
            trainingLocalUseCase.insertTable(
                TrainingLocalModel(
                    exercises = listOfExercises,
                    nameOfTrainingEntity = nameOfTrain
                )
            )
        }
    }
}