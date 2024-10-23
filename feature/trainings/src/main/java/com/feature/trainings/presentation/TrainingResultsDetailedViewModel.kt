package com.feature.trainings.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingResultLocalModel
import com.example.database.domain.TrainingResultLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrainingResultsDetailedViewModel @Inject constructor(
    private val trainingResultLocalUseCase: TrainingResultLocalUseCase
): ViewModel() {
    var trainingResult: TrainingResultLocalModel? = null
    fun getTrainingResultByID(id: Int) {
        viewModelScope.launch {
            trainingResult = trainingResultLocalUseCase.getTrainingResultById(id)
        }
    }
    init {
        Log.d("LOL", "trainingResultVM = ${this}")
    }
}