package com.feature.trainings.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.Routes
import com.example.core.common_files.common_ui.VerticalMargin
import com.example.database.data.model.TrainingLocalModel
import com.example.database.utils.ConvertersArguments

@Composable
fun SavedTrainingsScreen(
    viewModelFactory: ViewModelProvider.Factory,
    navController: NavController,
    context: Context
) {
    val viewModel: SavedTrainingsViewModel = viewModel(factory = viewModelFactory)
    val trainings by viewModel.trainings.collectAsState()
    Surface(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        if (trainings.isNotEmpty()) {
            LazyColumn {
                itemsIndexed(trainings) { index, training ->
                    Box(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    "${Routes.LISTOFEXERCISESSCREEN.name}/${
                                        ConvertersArguments().fromTrainingLocalModel(
                                            training
                                        )
                                    }"
                                )
                            }
                    ) {
                        Column {
                            VerticalMargin(Paddings.medium)
                            DesignedText(
                                context.resources.getString(
                                    com.example.core.R.string.name_of_train_s,
                                    training.nameOfTrainingEntity
                                )
                            )
                            VerticalMargin(Paddings.medium)
                            DesignedText(
                                context.resources.getString(
                                    com.example.core.R.string.quantity_of_exercises_s,
                                    training.exercises.size.toString()
                                )
                            )
                            VerticalMargin(Paddings.medium)
                            ButtonDelete(
                                viewModel = viewModel,
                                training = training
                            )
                            VerticalMargin(Paddings.medium)
                            if (trainings.lastIndex != index) {
                                Spacer(
                                    modifier = Modifier.height(Paddings.small).fillMaxWidth()
                                        .background(
                                            colorResource(com.example.core.R.color.aquamarine)
                                        )
                                )
                            }
                        }
                    }
                }
            }
        } else {
            NoOneTrainingText()
        }
    }
}

@Composable
fun NoOneTrainingText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(com.example.core.R.string.no_training_saved),
            fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
            color = Color.Gray,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DesignedText(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Paddings.medium)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
            fontSize = 24.sp,
            color = colorResource(com.example.core.R.color.air)
        )
    }
}

@Composable
fun ButtonDelete(
    viewModel: SavedTrainingsViewModel,
    training: TrainingLocalModel
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = Paddings.medium)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.deleteTraining(training)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(com.example.core.R.color.red_delete)
            )
        ) {
            Text(
                text = stringResource(com.example.core.R.string.delete),
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 16.sp,
                color = colorResource(com.example.core.R.color.white)
            )
        }
    }
}
