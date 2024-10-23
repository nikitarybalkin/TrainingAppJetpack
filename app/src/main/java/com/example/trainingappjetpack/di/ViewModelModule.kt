package com.example.trainingappjetpack.di

import androidx.lifecycle.ViewModel
import com.example.core.common_files.di.ViewModelKey
import com.feature.creation.presentation.CreateTrainingViewModel
import com.feature.entry.presentation.EntryViewModel
import com.feature.trainings.presentation.SavedTrainingsViewModel
import com.feature.trainings.presentation.TrainingResultsDetailedViewModel
import com.feature.trainings.presentation.TrainingViewModel
import com.feature.trainings.presentation.TrainingsResultsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CreateTrainingViewModel::class)
    abstract fun bindsCreateTrainingViewModel(viewModel: CreateTrainingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EntryViewModel::class)
    abstract fun bindsEntryViewModel(viewModel: EntryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedTrainingsViewModel::class)
    abstract fun bindsSavedTrainingsViewModel(viewModel: SavedTrainingsViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(TrainingViewModel::class)
    abstract fun bindsTrainingViewModel(viewModel: TrainingViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(TrainingResultsDetailedViewModel::class)
    abstract fun bindsTrainingResultsDetailedViewModel(viewModel: TrainingResultsDetailedViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(TrainingsResultsViewModel::class)
    abstract fun bindsTrainingsResultsViewModel(viewModel: TrainingsResultsViewModel): ViewModel
}