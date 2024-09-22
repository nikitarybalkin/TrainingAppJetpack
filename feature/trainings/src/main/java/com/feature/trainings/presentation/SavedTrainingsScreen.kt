package com.feature.trainings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.core.common_files.Paddings
import com.feature.trainings.R

/*@Composable
fun SavedTrainingsScreen(list: TrainingModel) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        LazyColumn {
            items(list) {
                Row (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(Paddings.medium))
                    Text(
                        text = stringResource(com.example.core.R.string.name_of_train),
                        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                        fontSize = 24.sp,
                        color = colorResource(com.example.core.R.color.air)
                    )
                    Spacer(modifier = Modifier.width(Paddings.medium))
                    Text(
                        text = stringResource(list),
                        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                        fontSize = 24.sp,
                        color = colorResource(com.example.core.R.color.air)
                    )
                }
                Spacer(modifier = Modifier.height(Paddings.medium))
                Row (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(Paddings.medium))
                    Text(
                        text = stringResource(com.example.core.R.string.count_of_exercises),
                        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                        fontSize = 24.sp,
                        color = colorResource(com.example.core.R.color.air)
                    )
                    Spacer(modifier = Modifier.width(Paddings.medium))
                    Text(
                        text = stringResource(list),
                        fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                        fontSize = 24.sp,
                        color = colorResource(com.example.core.R.color.air)
                    )
                }
                Spacer(modifier = Modifier.height(Paddings.medium))
                Spacer(modifier = Modifier.height(Paddings.small).fillMaxWidth().background(
                    colorResource(com.example.core.R.color.aquamarine)
                ))

            }
        }
    }
}*/