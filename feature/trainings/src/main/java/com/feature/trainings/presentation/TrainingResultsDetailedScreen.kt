package com.feature.trainings.presentation

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.R
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.VerticalMargin
import com.example.database.data.model.TrainingResultLocalModel

@Composable
fun TrainingResultsDetailedScreen(
    viewModelFactory: ViewModelProvider.Factory,
    id: Int,
    context: Context
) {
    val viewModel: TrainingResultsDetailedViewModel = viewModel(factory = viewModelFactory)
    val trainingResult = viewModel.trainingResult.collectAsState()
    viewModel.getTrainingResultByID(id)
    trainingResult.value?.let {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.grey)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                VerticalMargin(Paddings.medium)
                Text(
                    modifier = Modifier,
                    text = it.nameOfTrain,
                    fontFamily = FontFamily(Font(R.font.archivo_bold)),
                    fontSize = 40.sp,
                    color = colorResource(R.color.air)
                )
                VerticalMargin(Paddings.medium)
                Spacer(
                    modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                        colorResource(R.color.aquamarine)
                    )
                )
                VerticalMargin(Paddings.medium)
                Text(
                    modifier = Modifier,
                    text = it.date,
                    fontFamily = FontFamily(Font(R.font.archivo_sembold)),
                    fontSize = 30.sp,
                    color = colorResource(R.color.air)
                )
                VerticalMargin(Paddings.medium)
                Spacer(
                    modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                        colorResource(R.color.aquamarine)
                    )
                )
                VerticalMargin(Paddings.medium)
                Text(
                    modifier = Modifier,
                    text = it.time,
                    fontFamily = FontFamily(Font(R.font.archivo_sembold)),
                    fontSize = 30.sp,
                    color = colorResource(R.color.air)
                )
                VerticalMargin(Paddings.medium)
                Spacer(
                    modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                        colorResource(R.color.aquamarine)
                    )
                )
                LazyColumn(
                    modifier = Modifier.wrapContentSize()
                    ) {
                    itemsIndexed(it.exercises) { index, item ->
                        OneExerciseResult(it, index, context)
                    }
                }
            }
        }
    }
}

@Composable
private fun OneExerciseResult(
    trainingResult: TrainingResultLocalModel,
    index: Int,
    context: Context
) {
    VerticalMargin(Paddings.small)
    Column {
        Column (
            modifier = Modifier.padding(horizontal = Paddings.medium)
        ) {
            VerticalMargin(Paddings.medium)
            TextForExerciseResult(
                context.getString(R.string.name_of_exercise_s, trainingResult.exercises[index])
            )

            VerticalMargin(Paddings.medium)
            val startEnd = calculateStartAndEndSet(index = index, countOfSets = trainingResult.countOfSets)
            TextForExerciseResult(
                context.getString(R.string.quantity_of_repeats_s, convertExercisesOrWeight(trainingResult.countInSet, startOfSet = startEnd[0], endOfSet = startEnd[1]))
            )
            VerticalMargin(Paddings.medium)
            TextForExerciseResult(
                context.getString(R.string.quantity_of_sets_s, trainingResult.countOfSets[index].toString())
            )
            VerticalMargin(Paddings.medium)
            TextForExerciseResult(
                context.getString(R.string.weights_s, convertExercisesOrWeight(trainingResult.weights, startOfSet = startEnd[0], endOfSet = startEnd[1]))
            )
            VerticalMargin(Paddings.medium)
        }
        if (trainingResult.exercises.lastIndex != index) {
            Spacer(
                modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall)
                    .background(
                        colorResource(R.color.aquamarine)
                    )
            )
        }
    }
}

@Composable
fun TextForExerciseResult(
    text: String
) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.archivo_medium)),
        fontSize = 20.sp,
        color = colorResource(R.color.air)
    )
}

private fun calculateStartAndEndSet(
    index: Int,
    countOfSets: List<Int>
) : List<Int> {
    if (index == 0) {
        return listOf(0, countOfSets[index] - 1)
    } else {
        var countStart = 0
        for (i in 0..index-1) {
            countStart = countStart + countOfSets[i]
        }
        return listOf(countStart, countStart + countOfSets[index] - 1)
    }
}
private fun convertExercisesOrWeight(
    list: List<Any>,
    startOfSet: Int,
    endOfSet: Int
): String {
    var result = ""
    if (list.first() is Int) {
        for (i in startOfSet..endOfSet) {
            result = "$result ${list[i]}"
            if (i != endOfSet) result = "$result | "
        }
    } else {
        for (i in startOfSet..endOfSet) {
            result = "$result ${list[i]}"
            if (i != endOfSet) result = "$result | "
        }
    }
    return result
}

