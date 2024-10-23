package com.feature.trainings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingResultLocalModel
import com.example.database.domain.TrainingResultLocalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrainingsResultsViewModel @Inject constructor(
    private val trainingResultLocalUseCase: TrainingResultLocalUseCase
): ViewModel() {
    var trainingResult: MutableStateFlow<List<TrainingResultLocalModel>?> = MutableStateFlow(null)
    init {
        viewModelScope.launch {
            trainingResultLocalUseCase.getAll().collect {
                it?.let {
                    trainingResult.value = it
                }
            }

        }
    }
    fun deleteTrainingResult(trainingResult: TrainingResultLocalModel) {
        viewModelScope.launch {
            trainingResultLocalUseCase.delete(trainingResult)
        }
    }
}