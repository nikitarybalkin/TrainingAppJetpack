package com.example.trainingappjetpack.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.feature.creation.presentation.CreateTrainingScreen
import com.feature.trainings.presentation.Routes
import javax.inject.Inject

@Composable
fun AppNavHost (
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModelFactory: ViewModelProvider.Factory
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.CREATETRAININGSCREEN.name) {
            CreateTrainingScreen(viewModelFactory)
        }

    }
}