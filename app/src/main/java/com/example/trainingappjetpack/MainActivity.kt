package com.example.trainingappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.trainingappjetpack.di.App
import com.example.trainingappjetpack.presentation.AppNavHost
import com.example.trainingappjetpack.ui.theme.TrainingAppJetpackTheme
import com.feature.trainings.presentation.Routes
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        setContent {
            var navController = rememberNavController()
            AppNavHost(
                modifier = Modifier,
                navController = navController,
                startDestination = Routes.CREATETRAININGSCREEN.name,
                viewModelFactory = factory
            )
        }
    }
}

