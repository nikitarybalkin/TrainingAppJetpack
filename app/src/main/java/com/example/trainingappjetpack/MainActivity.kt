package com.example.trainingappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.trainingappjetpack.di.App
import com.example.trainingappjetpack.presentation.AppNavHost
import com.example.core.common_files.common_ui.Routes
import com.example.trainingappjetpack.presentation.BottomItems
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
        setContent {
            val navController = rememberNavController()
            AppNavHost(
                modifier = Modifier,
                navController = navController,
                startDestination = Routes.ENTRYSCREEN.name,
                viewModelFactory = factory,
                bottomItems = listOf(
                    BottomItems(
                        title = stringResource(com.example.core.R.string.main),
                        icon = painterResource(com.example.core.R.drawable.main_selected),
                    ),
                    BottomItems(
                        title = stringResource(com.example.core.R.string.add),
                        icon = painterResource(com.example.core.R.drawable.add_selected),
                    ),
                    BottomItems(
                        title = stringResource(com.example.core.R.string.your_trainings),
                        icon = painterResource(com.example.core.R.drawable.your_trainings_selected),
                    ),
                    BottomItems(
                        title = stringResource(com.example.core.R.string.your_results),
                        icon = painterResource(com.example.core.R.drawable.your_results_selected),
                    )
                ),
                context = this
            )
        }
    }
}

