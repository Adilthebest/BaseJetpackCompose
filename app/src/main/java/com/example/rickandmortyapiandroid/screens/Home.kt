package com.example.rickandmortyapiandroid.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmortyapiandroid.R
import com.example.rickandmortyapiandroid.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(btnClick: () -> Unit,
         navController: NavController) {
    val list = arrayListOf(
        "1" ,
        "2",
        "3",
        "4",
        "5",
        "6",
        "Abc",
        "Abc",
        "Abc",
        "Abc",
        "Abc",
        "Abc",
        "bggvfcd",
    )
    val textFieldText = remember {
        mutableStateOf("")
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
        Text(text = "Hello world!")

        OutlinedTextField(
            value = textFieldText.value, onValueChange = { it -> textFieldText.value = it },
            label = { Text(text = "Name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainColor,
                unfocusedBorderColor = Color.LightGray
            ),
        )
        Button(onClick = { btnClick.invoke() }, colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Save", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        LazyColumn() {
//            itemsIndexed(list){index, item ->  
//                Item(title = item)
//            }
            itemsIndexed(list) { intex, item ->
                Item(title = item)
            }
        }
    }
}

@Composable
fun Item(title: String) {
    Text(text = title, modifier = Modifier.clickable {
        Log.e("ololo", "Item:${title} ", )
    })
}