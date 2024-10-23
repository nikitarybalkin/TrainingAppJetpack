package com.feature.entry.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.data.model.TrainingResultLocalModel
import com.example.database.domain.TrainingResultLocalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EntryViewModel @Inject constructor(
    private val trainingResultLocalUseCase: TrainingResultLocalUseCase
): ViewModel() {
    val trainings: MutableStateFlow<TrainingResultLocalModel?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            trainingResultLocalUseCase.getLastTR().collect {
                if (it != null) {
                    trainings.value = it
                }
            }
        }
    }
}