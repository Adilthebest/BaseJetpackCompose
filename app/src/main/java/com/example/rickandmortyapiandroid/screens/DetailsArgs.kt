package com.example.rickandmortyapiandroid.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.navigation.NavHostController
import com.example.rickandmortyapiandroid.User
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapiandroid.Screens


@Composable
fun DetailArgs(navHostController: NavHostController, user: ArrayList<User?>) {
    val list = arrayListOf(
        "dcddcc", "dcdd,", "dc","dc","dc","dc","dc"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                16.dp
            )
    ) {
        LazyColumn {
            itemsIndexed(list) { _, item ->
                Text(text = item)
            }

        }

        Button(
            onClick = { navHostController.navigateUp() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Black),

            ) {

        }
    }
}

@Composable
fun Items(user: User, navHostController: NavHostController) {
    Column(Modifier.fillMaxWidth()) {
        Text("number: ${user.number}", Modifier.clickable {
            navHostController.currentBackStackEntry?.savedStateHandle?.set(
                key = "back",
                value = "true"
            )
            navHostController.navigate(Screens.SignUpScreen.route)
        })
        Text("password: ${user.password}")
        Text("confimPassword: ${user.confimPassword}")
        Text("email: ${user.email}")
    }
}