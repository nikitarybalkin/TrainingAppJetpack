package com.feature.creation.presentation

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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

@Composable
fun CreateTrainingScreen(
    viewModelFactory: ViewModelProvider.Factory,
    context: Context,
    navController: NavController,
) {
    val viewModel: CreateTrainingViewModel = viewModel(factory = viewModelFactory)
    val nameOfExercise = remember { mutableStateOf(viewModel.nameOfExercise) }
    val nameOfTrain = remember { mutableStateOf(viewModel.nameOfTrain) }
    val showDialog = remember { mutableStateOf(false) }
    fun clickNextExercise() {
        viewModel.listOfExercises.add(viewModel.nameOfExercise)
        viewModel.nameOfExercise = ""
        nameOfExercise.value = ""
    }

    fun clickSaveTraining() {
        if (viewModel.nameOfTrain != "") {
            if (viewModel.listOfExercises.size != 0) {
                viewModel.sendToDatabase()
                navController.navigate(Routes.ENTRYSCREEN.name)
            } else Toast.makeText(context, context.resources.getString(com.example.core.R.string.no_training_saved), Toast.LENGTH_SHORT).show()
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(Paddings.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(com.example.core.R.string.creation_of_training),
                textAlign = TextAlign.Center,
                color = colorResource(com.example.core.R.color.air),
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 24.sp
            )
            VerticalMargin(Paddings.medium)
            DesignedTextField(
                textValue = nameOfTrain,
                viewModel = viewModel
            )
            VerticalMargin(Paddings.medium)
            DesignedTextField(
                textValue = nameOfExercise,
                viewModel = viewModel
            )
            VerticalMargin(Paddings.medium)
            DoubleButton(
                clickNextExercise = {clickNextExercise()},
                clickSaveTraining = {clickSaveTraining()}
            )
        }
    }
    if (showDialog.value) {
        AlertAboutExit(
            navController,
            showDialog
        )
    }
    BackHandler {
        showDialog.value = true
    }
}

@Composable
fun DesignedTextField(
    textValue: MutableState<String>,
    viewModel: CreateTrainingViewModel
) {
    TextField(
        value = textValue.value,
        onValueChange = { new ->
            textValue.value = new
            viewModel.nameOfExercise = new
        },
        placeholder = { Text(stringResource(com.example.core.R.string.name_of_exercise)) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.DarkGray,
            unfocusedPlaceholderColor = Color.Gray,
            focusedContainerColor = Color.DarkGray,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}

@Composable
fun DoubleButton(
    clickNextExercise: () -> Unit,
    clickSaveTraining: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(colorResource(com.example.core.R.color.blue_light))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier,
                onClick = {clickNextExercise()},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = stringResource(com.example.core.R.string.next_exercise),
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
                onClick = {clickSaveTraining()},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = stringResource(com.example.core.R.string.save_training),
                    color = Color.Black
                )
            }
        }
    }
}
