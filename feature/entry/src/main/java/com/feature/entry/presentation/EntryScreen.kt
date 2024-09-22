package com.feature.entry.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.common_files.Paddings
import com.feature.entry.R

@Composable
fun EntryScreen() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = colorResource(com.example.core.R.color.grey)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(com.example.core.R.string.today_is_prefect_day),
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_bold)),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = colorResource(com.example.core.R.color.air)
            )
            Spacer(modifier = Modifier.height(Paddings.medium))
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(com.example.core.R.string.your_last_training),
                fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                fontSize = 24.sp,
                color = colorResource(com.example.core.R.color.air)
            )
            Spacer(modifier = Modifier.height(Paddings.small))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(colorResource(com.example.core.R.color.blue_light))
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f),
                    text = stringResource(com.example.core.R.string.date),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
                Spacer(modifier = Modifier.width(4.dp).height(50.dp).background(colorResource(com.example.core.R.color.blue_light)))
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f).height(50.dp),
                    text = stringResource(com.example.core.R.string.name_of_train),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
                Spacer(modifier = Modifier.width(4.dp).height(50.dp).background(colorResource(com.example.core.R.color.blue_light)))
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f),
                    text = stringResource(com.example.core.R.string.time),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_sembold)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(colorResource(com.example.core.R.color.blue_light))
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f),
                    text = stringResource(com.example.core.R.string.date),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_regular)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
                Spacer(modifier = Modifier.width(4.dp).height(50.dp).background(colorResource(com.example.core.R.color.blue_light)))
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f),
                    text = stringResource(com.example.core.R.string.name_of_train),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_regular)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
                Spacer(modifier = Modifier.width(4.dp).height(50.dp).background(colorResource(com.example.core.R.color.blue_light)))
                Text(
                    modifier = Modifier.fillMaxWidth(0.25f),
                    text = stringResource(com.example.core.R.string.time),
                    fontFamily = FontFamily(Font(com.example.core.R.font.archivo_regular)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(com.example.core.R.color.air)
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(colorResource(com.example.core.R.color.blue_light))
            )
        }
    }

}

@Preview
@Composable
fun EntryScreenPreview() {
    EntryScreen()
}
