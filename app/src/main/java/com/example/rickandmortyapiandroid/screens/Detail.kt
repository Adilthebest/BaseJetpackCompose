package com.example.rickandmortyapiandroid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapiandroid.R
import com.example.rickandmortyapiandroid.ui.theme.color1
import com.example.rickandmortyapiandroid.ui.theme.color2

@Composable
fun Detail(
    onClickUp:()-> Unit,
    onClickIn:()-> Unit,
) {
    @Composable
    fun GradientButton(
        text: String,
        textColor: Color,
        gradient: Brush,
        onClick: () -> Unit
    ) {
        Button(colors = ButtonDefaults.buttonColors(Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { onClick() }) {
            Box(
                modifier = Modifier
                    .background(gradient)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = textColor)
            }

        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Image",
            modifier = Modifier
                .padding(26.dp)
                .width(300.dp)
                .height(300.dp)
        )
        Text(
            text = "Welcome to Relaxify!",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Risus euismod lacus, pharetra dui.",
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 65.dp, end = 40.dp)
                .padding(10.dp)
        )
        Button(
            onClick = {onClickUp()},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .padding(
                    top = 100.dp, start = 25.dp,
                    end = 25.dp
                )
                .fillMaxWidth()
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )

        }
        Button(
            onClick = {onClickIn()},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier.padding(
                top = 20.dp,
                start = 25.dp,
                end = 25.dp
            )
        ) {
            Text(
                text = "Sign in",
                color = Color.Blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )

        }

        GradientButton(
            text = "Button", textColor = Color.White, gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        ) {

        }
    }

}