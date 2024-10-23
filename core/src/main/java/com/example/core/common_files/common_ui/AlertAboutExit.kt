package com.example.core.common_files.common_ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun AlertAboutExit(
    navController: NavController,
    showDialog: MutableState<Boolean>
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(stringResource(com.example.core.R.string.alert_title))
        },
        text = {
            Text(stringResource(com.example.core.R.string.alert_text))
        },
        confirmButton = {
            Button(
                onClick = {
                    showDialog.value = false
                    navController.popBackStack()
                }
            ) {
                Text(stringResource(com.example.core.R.string.alert_button_yes))
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    showDialog.value = false
                }
            ) {
                Text(stringResource(com.example.core.R.string.alert_button_no))
            }
        }
    )
}