package com.jetpack.bottomappbarwithfloaticon

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FloatAlertDialog(openDialog: MutableState<Boolean>) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Floating Action", fontWeight = FontWeight.Bold)
            },
            text = {
                Text(text = "Let's Start...")
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(text = "Ok")
                }
            }
        )
    }
}











