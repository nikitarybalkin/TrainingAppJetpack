package com.example.trainingappjetpack.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.common_files.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}