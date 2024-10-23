package com.example.trainingappjetpack.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.feature.creation.presentation.CreateTrainingScreen
import com.feature.entry.presentation.EntryScreen
import com.example.core.common_files.common_ui.Routes
import com.example.database.utils.ConvertersArguments
import com.feature.trainings.presentation.ListOfExercisesScreen
import com.feature.trainings.presentation.SavedTrainingsScreen
import com.feature.trainings.presentation.TrainingResultsDetailedScreen
import com.feature.trainings.presentation.TrainingResultsScreen
import com.feature.trainings.presentation.TrainingScreen

data class BottomItems(
    val title: String,
    val icon: Painter,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModelFactory: ViewModelProvider.Factory,
    bottomItems: List<BottomItems>,
    context: Context
) {
    val selectedBottomItem = remember { mutableStateOf(0) }
    val screenWithData: MutableState<Boolean> = remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = {
            if (!screenWithData.value) {
                NavigationBar (
                    containerColor = Color.DarkGray,
                    contentColor = colorResource(com.example.core.R.color.air)
                ) {
                    bottomItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = colorResource(com.example.core.R.color.aquamarine),
                                unselectedTextColor = Color.Black,
                                selectedIconColor = colorResource(com.example.core.R.color.aquamarine),
                                unselectedIconColor = Color.Black,
                                indicatorColor = Color.Transparent
                            ),
                            selected = selectedBottomItem.value == index,
                            onClick = {
                                selectedBottomItem.value = index
                                when (item.title) {
                                    context.resources.getString(com.example.core.R.string.main) -> {
                                        navController.navigate(Routes.ENTRYSCREEN.name)
                                    }
                                    context.resources.getString(com.example.core.R.string.add) -> {
                                        navController.navigate(Routes.CREATETRAININGSCREEN.name)
                                    }
                                    context.resources.getString(com.example.core.R.string.your_trainings) -> {
                                        navController.navigate(Routes.SAVEDTRAININGSSCREEN.name)
                                    }
                                    context.resources.getString(com.example.core.R.string.your_results) -> {
                                        navController.navigate(Routes.TRAININGRESULTSSCREEN.name)
                                    }
                                }
                            },
                            label = {Text(item.title)},
                            icon = {
                                Icon(
                                    modifier = Modifier.size(20.dp),
                                    painter = item.icon,
                                    contentDescription = item.title
                                )
                            }
                        )
                    }
                }
            }
        }
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            composable(Routes.CREATETRAININGSCREEN.name) {
                screenWithData.value = true
                CreateTrainingScreen(viewModelFactory, context, navController)
            }
            composable(Routes.ENTRYSCREEN.name) {
                screenWithData.value = false
                EntryScreen(
                    viewModelFactory,
                    navController
                )
            }
            composable(Routes.SAVEDTRAININGSSCREEN.name) {
                screenWithData.value = false
                SavedTrainingsScreen(viewModelFactory, navController, context)
            }
            composable("${Routes.LISTOFEXERCISESSCREEN.name}/{training}") { navBackStackEntry ->
                val training = navBackStackEntry.arguments?.getString("training")
                training?.let {
                    screenWithData.value = false
                    ListOfExercisesScreen(
                        training = ConvertersArguments().toTrainingLocalModel(training),
                        navController = navController
                    )
                }
            }
            composable("${Routes.TRAININGSCREEN.name}/{training}") { navBackStackEntry ->
                val training = navBackStackEntry.arguments?.getString("training")
                training?.let {
                    screenWithData.value = true
                    TrainingScreen(
                        training = ConvertersArguments().toTrainingLocalModel(training),
                        navController = navController,
                        viewModelFactory = viewModelFactory,
                        context = context
                    )
                }
            }
            composable(Routes.TRAININGRESULTSSCREEN.name) {
                screenWithData.value = false
                TrainingResultsScreen(
                    context,
                    viewModelFactory,
                    navController,
                    itIsBottomSheet = false,
                    bottomSheetIsDetailed = null,
                    //Здесь надо по-человечески сделать
                    idForDetailed = remember { mutableStateOf(null) }
                )
            }
            composable("${Routes.TRAININGRESULTSDETAILEDSCREEN.name}/{id}") { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id")
                id?.let {
                    screenWithData.value = true
                    TrainingResultsDetailedScreen(
                        viewModelFactory,
                        it.toInt(),
                        context
                    )
                }
            }
        }
    }
}
