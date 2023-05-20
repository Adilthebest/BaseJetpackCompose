package com.example.rickandmortyapiandroid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapiandroid.R
import com.example.rickandmortyapiandroid.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SignIn() {
    val number = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Column(
        Modifier.fillMaxSize().padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding( bottom = 60.dp )
                .height(300.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(
                text = "Hello Welcome!",
                fontSize = 26.sp,
                modifier = Modifier.width(150.dp)

            )
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Image",
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
            )
        }
        OutlinedTextField(
            value = number.value, onValueChange = { it -> number.value = it },
            label = { Text(text = "Phone Number or Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        OutlinedTextField(
            value = password.value, onValueChange = { it -> password.value = it },
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()

        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier
        ) {
            Text(
                text = "Sign in",
                color = Color.Blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
            )
        }
        Text(
            text = "or Sign in with",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(end = 150.dp)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .height(200.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource
                    (id = R.drawable.social_media),
                contentDescription = "Image",
                Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 25.dp, end = 140.dp)

                )
        }
    }
}