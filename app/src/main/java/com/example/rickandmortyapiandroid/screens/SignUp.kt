@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.rickandmortyapiandroid.R
import com.example.rickandmortyapiandroid.Screens
import com.example.rickandmortyapiandroid.User
import com.example.rickandmortyapiandroid.ui.theme.MainColor

@Composable
fun SignUp(navController: NavHostController,user: User? = null) {

    val name = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val confimPassword = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.image
            ),
            contentDescription = "image",
            Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = "Registration",
            fontSize = 36.sp,
            color = Color.Black
        )

        OutlinedTextField(
            value = name.value, onValueChange = { it -> name.value = it },
            label = { Text(text = "Name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        OutlinedTextField(
            value = email.value, onValueChange = { it -> email.value = it},
            label = { Text(text = user.toString()) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { it -> password.value = it },
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedTextField(
            value = confimPassword.value,
            onValueChange = { it -> confimPassword.value = it },
            label = { Text(text = "Confirm Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
                val user = User(name.value, email.value, password.value,confimPassword.value)

                navController.currentBackStackEntry?.savedStateHandle?.set(
                          key = "person",
                          value = user
                      )
                navController.navigate(Screens.DetailArgs.route)
                      },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .height(75.dp)
                .width(250.dp)
                .padding(top = 20.dp, start = 60.dp)
        ) {
            Text(
                text = "Sign up", color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}