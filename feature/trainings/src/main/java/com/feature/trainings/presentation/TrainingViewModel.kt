package com.feature.trainings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingResultLocalModel
import com.example.database.domain.TrainingResultLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrainingViewModel @Inject constructor(
    private val trainingResultLocalUseCase: TrainingResultLocalUseCase
): ViewModel() {
    var countOfSets: MutableList<Int> = mutableListOf()
    var nameOfTrain: String = ""
    var listOfExercises: MutableList<String> = mutableListOf()
    var countInSet: MutableList<Int> = mutableListOf()
    var weights: MutableList<Double> = mutableListOf()
    var setsInOneExercise = 0
    var date: String = ""
    var time: String = ""
    fun addTrainingResult() {
        viewModelScope.launch {
            trainingResultLocalUseCase.insert(
                TrainingResultLocalModel(
                    nameOfTrain = nameOfTrain,
                    exercises = listOfExercises,
                    countInSet = countInSet,
                    countOfSets = countOfSets,
                    weights = weights,
                    date = date,
                    time = time
                )
            )
        }
    }
}