@file:OptIn(ExperimentalMaterial3Api::class)

package com.feature.trainings.presentation

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.AlertAboutExit
import com.example.core.common_files.common_ui.Routes
import com.example.core.common_files.common_ui.VerticalMargin
import com.example.database.data.model.TrainingLocalModel
import java.lang.System.currentTimeMillis
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingScreen(
    navController: NavController,
    training: TrainingLocalModel,
    viewModelFactory: ViewModelProvider.Factory,
    context: Context
) {
    val viewModel: TrainingViewModel = viewModel(factory = viewModelFactory)
    val bottomSheetExercisesState = rememberModalBottomSheetState()
    val bottomSheetExercisesIsOpen = remember { mutableStateOf(false) }
    val bottomSheetTrainingResultsState = rememberModalBottomSheetState()
    val bottomSheetTrainingResultsIsOpen = remember { mutableStateOf(false) }
    val selectedExercise =
        remember { mutableStateOf(context.resources.getString(com.example.core.R.string.to_choose_exercise)) }
    val countInSet = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    val finishButtonEnabled = remember { mutableStateOf(false) }
    val nextExerciseEnabled = remember { mutableStateOf(false) }
    val startTime = currentTimeMillis()
    val currentSet = remember { mutableStateOf(viewModel.setsInOneExercise) }
    val showDialog = remember { mutableStateOf(false) }
    viewModel.nameOfTrain = training.nameOfTrainingEntity
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            VerticalMargin(Paddings.medium)
            Text(
                text = training.nameOfTrainingEntity,
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 30.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            VerticalMargin(Paddings.medium)
            Spacer(
                modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                    colorResource(com.example.core.R.color.aquamarine)
                )
            )
            VerticalMargin(Paddings.medium)
            Text(
                modifier = Modifier.clickable {
                    bottomSheetExercisesIsOpen.value = true
                },
                text = selectedExercise.value,
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 20.sp,
                color = colorResource(com.example.core.R.color.air)
            )

            if (bottomSheetTrainingResultsIsOpen.value) {
                BottomSheetTrainingResults(
                    bottomSheetExercisesIsOpen = bottomSheetExercisesIsOpen,
                    bottomSheetTrainingResultsState = bottomSheetTrainingResultsState,
                    navController = navController,
                    viewModelFactory = viewModelFactory,
                    context = context,
                    bottomSheetTrainingResultsIsOpen = bottomSheetTrainingResultsIsOpen
                )
            }

            if (bottomSheetExercisesIsOpen.value) {
                BottomSheetExercises(
                    bottomSheetExercisesIsOpen = bottomSheetExercisesIsOpen,
                    bottomSheetExercisesState = bottomSheetExercisesState,
                    selectedExercise = selectedExercise,
                    training = training,
                    bottomSheetTrainingResultsIsOpen = bottomSheetTrainingResultsIsOpen
                )
            }

            VerticalMargin(Paddings.medium)
            Spacer(
                modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                    colorResource(com.example.core.R.color.aquamarine)
                )
            )
            VerticalMargin(Paddings.medium)
            Text(
                text = if (currentSet.value == 0) stringResource(com.example.core.R.string.number_of_set) else currentSet.value.toString(),
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 20.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            VerticalMargin(Paddings.medium)
            Spacer(
                modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                    colorResource(com.example.core.R.color.aquamarine)
                )
            )
            VerticalMargin(Paddings.medium)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextFieldForTraining(
                    countInSet
                )
                TextFieldForTraining(
                    weight
                )
            }
            VerticalMargin(Paddings.medium)
            TrippleButton(
                countInSet = countInSet,
                weight = weight,
                selectedExercise = selectedExercise,
                context = context,
                nextExerciseEnabled = nextExerciseEnabled,
                viewModel = viewModel,
                finishButtonEnabled = finishButtonEnabled,
                navController = navController,
                startTime = startTime
            )
            VerticalMargin(Paddings.medium)
            Button(
                modifier = Modifier,
                onClick = {
                    bottomSheetTrainingResultsIsOpen.value = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                )
            ) {
                Text(
                    text = context.resources.getString(com.example.core.R.string.open_last_results),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_medium)),
                    color = colorResource(com.example.core.R.color.air)
                )
            }
        }
        if (showDialog.value) {
            AlertAboutExit(
                showDialog = showDialog,
                navController = navController
            )
        }
        BackHandler {
            showDialog.value = true
        }
    }
}

@Composable
fun TextFieldForTraining(
    textValue: MutableState<String>
) {
    TextField(
        modifier = Modifier.width(160.dp).height(60.dp),
        value = textValue.value,
        onValueChange = { new ->
            textValue.value = new
        },
        textStyle = TextStyle(textAlign = TextAlign.Center),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = { Text(stringResource(com.example.core.R.string.enter_weight)) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.DarkGray,
            unfocusedPlaceholderColor = Color.Gray,
            focusedPlaceholderColor = Color.Gray,
            focusedContainerColor = Color.DarkGray,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}

@Composable
fun TrippleButton(
    countInSet: MutableState<String>,
    weight: MutableState<String>,
    selectedExercise: MutableState<String>,
    context: Context,
    nextExerciseEnabled: MutableState<Boolean>,
    viewModel: TrainingViewModel,
    finishButtonEnabled: MutableState<Boolean>,
    navController: NavController,
    startTime: Long
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(80.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(colorResource(com.example.core.R.color.blue_light))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = Paddings.extraSmall),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier,
                    onClick = {
                        clickNextSet(
                            countInSet = countInSet,
                            weight = weight,
                            selectedExercise = selectedExercise,
                            viewModel = viewModel,
                            context = context,
                            nextExerciseEnabled
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        text = stringResource(com.example.core.R.string.next_set),
                        color = Color.Black
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .width(1.dp)
                        .background(Color.Gray)
                        .clip(RoundedCornerShape(8.dp))
                )
                Button(
                    modifier = Modifier,
                    enabled = nextExerciseEnabled.value,
                    onClick = {
                        clickNextExercise(
                            countInSet = countInSet,
                            weight = weight,
                            selectedExercise = selectedExercise,
                            viewModel = viewModel,
                            context = context,
                            finishButtonEnabled
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = stringResource(com.example.core.R.string.next_exercise),
                        color = if (nextExerciseEnabled.value) Color.Black else Color.Gray
                    )
                }
            }
            Spacer(
                modifier = Modifier.fillMaxWidth().height(1.dp).background(
                    Color.Gray
                )
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = finishButtonEnabled.value,
                onClick = {
                    clickFinishTraining(
                        viewModel = viewModel,
                        navController = navController,
                        startTime
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                )
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(com.example.core.R.string.finish_training),
                    color = if (nextExerciseEnabled.value) Color.Black else Color.Gray
                )
            }
        }
    }
}

private fun clickNextSet(
    countInSet: MutableState<String>,
    weight: MutableState<String>,
    selectedExercise: MutableState<String>,
    viewModel: TrainingViewModel,
    context: Context,
    nextExerciseEnabled: MutableState<Boolean>
) {
    if (countInSet.value != "" && weight.value != "" && selectedExercise.value != context.resources.getString(
            com.example.core.R.string.to_choose_exercise
        )
    ) {
        viewModel.setsInOneExercise++
        viewModel.countInSet.add(countInSet.value.toInt())
        viewModel.weights.add(weight.value.toDouble())
        countInSet.value = ""
        weight.value = ""
        nextExerciseEnabled.value = true
    } else Toast.makeText(
        context,
        context.resources.getString(com.example.core.R.string.all_fields_must),
        Toast.LENGTH_SHORT
    ).show()
}

private fun clickNextExercise(
    countInSet: MutableState<String>,
    weight: MutableState<String>,
    selectedExercise: MutableState<String>,
    viewModel: TrainingViewModel,
    context: Context,
    finishButtonEnabled: MutableState<Boolean>
) {
    if (countInSet.value != "" && weight.value != "" && selectedExercise.value != context.resources.getString(
            com.example.core.R.string.to_choose_exercise
        )
    ) {
        viewModel.setsInOneExercise++
        viewModel.countInSet.add(countInSet.value.toInt())
        viewModel.weights.add(weight.value.toDouble())
        viewModel.countOfSets.add(viewModel.setsInOneExercise)
        viewModel.setsInOneExercise = 0
        viewModel.listOfExercises.add(selectedExercise.value)
        selectedExercise.value =
            context.resources.getString(com.example.core.R.string.to_choose_exercise)
        countInSet.value = ""
        weight.value = ""
        finishButtonEnabled.value = true
    } else {
        viewModel.countOfSets.add(viewModel.setsInOneExercise)
        viewModel.setsInOneExercise = 0
        viewModel.listOfExercises.add(selectedExercise.value)
        selectedExercise.value =
            context.resources.getString(com.example.core.R.string.to_choose_exercise)
        countInSet.value = ""
        weight.value = ""
        finishButtonEnabled.value = true
    }
}

private fun clickFinishTraining(
    viewModel: TrainingViewModel,
    navController: NavController,
    startTime: Long
) {
    viewModel.time = formatMillis(currentTimeMillis() - startTime)
    viewModel.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    viewModel.addTrainingResult()
    navController.navigate(Routes.ENTRYSCREEN.name)
}

private fun formatMillis(timeInMillis: Long): String {
    val seconds = (timeInMillis / 1000) % 60
    val minutes = (timeInMillis / 1000) / 60
    return String.format("%02d:%02d", minutes, seconds)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExercises(
    bottomSheetExercisesIsOpen: MutableState<Boolean>,
    bottomSheetExercisesState: SheetState,
    selectedExercise: MutableState<String>,
    training: TrainingLocalModel,
    bottomSheetTrainingResultsIsOpen: MutableState<Boolean>
) {
    bottomSheetTrainingResultsIsOpen.value = false
    ModalBottomSheet(
        onDismissRequest = { bottomSheetExercisesIsOpen.value = false },
        sheetState = bottomSheetExercisesState,
        containerColor = Color.DarkGray,
        dragHandle = { BottomSheetDefaults.DragHandle(color = colorResource(com.example.core.R.color.air)) }
    ) {
        LazyColumn {
            itemsIndexed(training.exercises) { index, training ->
                training?.let {
                    Spacer(
                        modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall)
                            .background(
                                colorResource(com.example.core.R.color.aquamarine)
                            )
                    )
                    VerticalMargin(Paddings.medium)
                    Text(
                        modifier = Modifier.fillMaxWidth().clickable {
                            selectedExercise.value = training
                            bottomSheetExercisesIsOpen.value = false
                        },
                        textAlign = TextAlign.Center,
                        text = training,
                        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                        fontSize = 30.sp,
                        color = colorResource(com.example.core.R.color.air)
                    )
                    VerticalMargin(Paddings.medium)
                }
            }
        }
    }
}

@Composable
fun BottomSheetTrainingResults(
    bottomSheetTrainingResultsIsOpen: MutableState<Boolean>,
    bottomSheetTrainingResultsState: SheetState,
    bottomSheetExercisesIsOpen: MutableState<Boolean>,
    navController: NavController,
    viewModelFactory: ViewModelProvider.Factory,
    context: Context
) {
    val bottomSheetIsDetailed = remember { mutableStateOf(false) }
    val idForDetailed: MutableState<Int?> = remember { mutableStateOf(null) }
    bottomSheetExercisesIsOpen.value = false
    ModalBottomSheet(
        onDismissRequest = { bottomSheetTrainingResultsIsOpen.value = false },
        sheetState = bottomSheetTrainingResultsState,
        containerColor = Color.DarkGray,
        dragHandle = { BottomSheetDefaults.DragHandle(color = colorResource(com.example.core.R.color.air)) }
    ) {
        if (!bottomSheetIsDetailed.value) {
            TrainingResultsScreen(
                context = context,
                navController = navController,
                viewModelFactory = viewModelFactory,
                itIsBottomSheet = true,
                bottomSheetIsDetailed = bottomSheetIsDetailed,
                idForDetailed = idForDetailed
            )
        } else {
            idForDetailed.value?.let {
                Log.d("LOL", "idForDetailed != null == ${it}")
                TrainingResultsDetailedScreen(
                    viewModelFactory = viewModelFactory,
                    context = context,
                    id = it
                )
            }

        }
    }
}