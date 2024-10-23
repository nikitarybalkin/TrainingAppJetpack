package com.feature.trainings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.LineAllWidth
import com.example.core.common_files.common_ui.Routes
import com.example.core.common_files.common_ui.VerticalMargin
import com.example.database.data.model.TrainingLocalModel
import com.example.database.utils.ConvertersArguments

@Composable
fun ListOfExercisesScreen(
    training: TrainingLocalModel,
    navController: NavController
) {
    Surface (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f),
        color = colorResource(com.example.core.R.color.grey),
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxHeight(0.9f).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (training.exercises.isNotEmpty()) {
                items(training.exercises) {
                    VerticalMargin(Paddings.medium)
                    ExerciseNameText(it!!)
                    VerticalMargin(Paddings.medium)
                    LineAllWidth()
                }
                item {
                    VerticalMargin(Paddings.medium)
                    Button(
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        onClick = {
                            navController.navigate("${Routes.TRAININGSCREEN.name}/${ConvertersArguments().fromTrainingLocalModel(training)}")
                        }
                    ) {
                        ExerciseNameText(stringResource(com.example.core.R.string.start_train))
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseNameText(
    nameOfExercise: String
) {
    Text(
        textAlign = TextAlign.Center,
        text = nameOfExercise,
        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
        fontSize = 24.sp,
        color = colorResource(com.example.core.R.color.air)
    )
}
