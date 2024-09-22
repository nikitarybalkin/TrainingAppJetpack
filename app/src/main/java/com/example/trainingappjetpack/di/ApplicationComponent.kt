package com.example.trainingappjetpack.di

import android.content.Context
import com.example.trainingappjetpack.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataBaseModule::class, ViewModelModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}