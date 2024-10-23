package com.feature.trainings.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.Routes
import com.example.core.common_files.common_ui.VerticalMargin

@Composable
fun TrainingResultsScreen(
    context: Context,
    viewModelFactory: ViewModelProvider.Factory,
    navController: NavController,
    itIsBottomSheet: Boolean,
    bottomSheetIsDetailed: MutableState<Boolean>?,
    idForDetailed: MutableState<Int?>
) {
    val viewModel: TrainingsResultsViewModel = viewModel(factory = viewModelFactory)
    val trainingResults = viewModel.trainingResult.collectAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = colorResource(com.example.core.R.color.grey)),
    ) {
        trainingResults.value?.let {
            itemsIndexed(it) { index, item ->
                Column(
                    modifier =
                    Modifier
                        .clickable {
                            if (!itIsBottomSheet)
                                navController.navigate("${Routes.TRAININGRESULTSDETAILEDSCREEN.name}/${item.id}")
                            else {
                                bottomSheetIsDetailed!!.value = true
                                idForDetailed.value = item.id
                            }
                        }
                ) {
                    VerticalMargin(Paddings.medium)
                    DesignedText(
                        context.resources.getString(
                            com.example.core.R.string.name_of_train_s,
                            item.nameOfTrain
                        )
                    )
                    VerticalMargin(Paddings.medium)
                    DesignedText(
                        context.resources.getString(
                            com.example.core.R.string.quantity_of_exercises_s,
                            item.exercises.size.toString()
                        )
                    )
                    VerticalMargin(Paddings.medium)
                    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = Paddings.medium)) {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.deleteTrainingResult(item)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(com.example.core.R.color.red_delete)
                            )
                        ) {
                            Text(
                                text = stringResource(com.example.core.R.string.delete),
                                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                                fontSize = 16.sp,
                                color = colorResource(com.example.core.R.color.air)
                            )
                        }
                    }
                    VerticalMargin(Paddings.medium)
                    Spacer(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(Paddings.small)
                            .background(
                                color = colorResource(
                                    com.example.core.R.color.aquamarine
                                )
                            )
                    )
                }
            }
        }
    }
}
