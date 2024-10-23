package com.feature.trainings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingLocalModel
import com.example.database.domain.TrainingLocalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SavedTrainingsViewModel @Inject constructor(
    private val trainingLocalUseCase: TrainingLocalUseCase
): ViewModel() {

    private val _trainings: MutableStateFlow<List<TrainingLocalModel>> = MutableStateFlow(emptyList())
    val trainings: StateFlow<List<TrainingLocalModel>> = _trainings.asStateFlow()
    init {
        viewModelScope.launch {
            trainingLocalUseCase.getAll().collect {
                if (it != null) {
                    _trainings.value = it
                }
            }
        }
    }
    fun deleteTraining(training: TrainingLocalModel) {
        viewModelScope.launch {
            trainingLocalUseCase.delete(training)
        }
    }

}