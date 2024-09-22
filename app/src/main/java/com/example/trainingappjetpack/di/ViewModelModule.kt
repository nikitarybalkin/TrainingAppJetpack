package com.example.trainingappjetpack.di

import androidx.lifecycle.ViewModel
import com.example.core.common_files.di.ViewModelKey
import com.feature.creation.presentation.CreateTrainingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CreateTrainingViewModel::class)
    abstract fun bindsCreateTrainingViewModel(viewModel: CreateTrainingViewModel): ViewModel
}