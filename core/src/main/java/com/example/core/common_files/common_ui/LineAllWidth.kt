package com.example.core.common_files.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.common_files.Paddings

@Preview
@Composable
fun LineAllWidth() {
    Spacer(modifier = Modifier.fillMaxWidth().height(Paddings.extraSmall).background(
        colorResource(com.example.core.R.color.aquamarine)
    ))
}