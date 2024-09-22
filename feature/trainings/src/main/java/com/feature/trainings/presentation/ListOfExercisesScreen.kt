package com.feature.trainings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core.common_files.Paddings
import com.feature.trainings.R

@Composable
fun ListOfExercisesScreen(list: List<String>) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(list) {
                Spacer(modifier = Modifier.height(Paddings.medium))
                Text(
                    text = it,
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                    fontSize = 24.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
                Spacer(modifier = Modifier.height(Paddings.medium))
                Spacer(modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                    colorResource(com.example.core.R.color.aquamarine)
                ))
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    ListOfExercisesScreen(
        listOf("1","2","3")
    )
}