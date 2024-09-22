package com.feature.trainings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core.common_files.Paddings
import com.example.core.common_files.common_ui.LineAllWidth
import com.example.core.common_files.common_ui.Margin

/*@Composable
fun TrainingResultsScreen(list: List<TrainingResultsModel>) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(Paddings.medium))
            Text(
                modifier = Modifier,
                text = "Name of train",
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 40.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            Spacer(modifier = Modifier.height(Paddings.medium))
            Spacer(modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                colorResource(com.example.core.R.color.aquamarine)
            ))
            Spacer(modifier = Modifier.height(Paddings.medium))
            Text(
                modifier = Modifier,
                text = "Date",
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                fontSize = 30.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            Spacer(modifier = Modifier.height(Paddings.medium))
            Spacer(modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                colorResource(com.example.core.R.color.aquamarine)
            ))
            Spacer(modifier = Modifier.height(Paddings.medium))
            Text(
                modifier = Modifier,
                text = "Time",
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                fontSize = 30.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            Spacer(modifier = Modifier.height(Paddings.medium))
            Spacer(modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
                colorResource(com.example.core.R.color.aquamarine)
            ))
            LazyColumn (
                modifier = Modifier,

            ) {

            }
        }
    }
}*/