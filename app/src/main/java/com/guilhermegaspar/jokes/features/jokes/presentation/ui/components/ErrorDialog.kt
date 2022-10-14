package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.guilhermegaspar.jokes.R
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.bodyText
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.primaryContainer

@Composable
fun ErrorDialog(errorMessage: String, onDismiss: () -> Unit, onTryAgain: () -> Unit) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(primaryContainer)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        painter = painterResource(id = R.drawable.connection_error),
                        contentDescription = "Imagem ilustrativa de erro",
                        alignment = Alignment.Center
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp),
                    text = errorMessage,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 36.dp, end = 36.dp, bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = bodyText),
                    onClick = {
                        onTryAgain()
                    }) {
                    Text(
                        text = "Tentar novamente",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}