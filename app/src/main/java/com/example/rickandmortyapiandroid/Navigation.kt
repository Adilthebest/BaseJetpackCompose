package com.example.rickandmortyapiandroid

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortyapiandroid.screens.*

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screens.HomeScreen.route
    ) {
        composable(
            Screens.HomeScreen.route)
        {
            Home(btnClick = {navController.navigate(Screens.DetailScreen.route)},navController)
        }
        composable(Screens.DetailScreen.route){
            Detail(
                onClickIn = {navController.navigate(Screens.SignInScreen.route)},
                onClickUp = {navController.navigate(Screens.SignUpScreen.route)})
        }
        composable(Screens.SignUpScreen.route){
            val signUp = navController.previousBackStackEntry?.savedStateHandle?.get<User>("back")
            if (signUp!=null){
                SignUp(navController = navController, user =signUp )
            }else{
SignUp(navController = navController )
            }
        }
        composable(Screens.SignInScreen.route){
            SignIn()
        }
        composable(Screens.DetailArgs.route){
            val result  =
                navController.previousBackStackEntry?.savedStateHandle?.get<User>("person")

             DetailArgs(navController, arrayListOf(result))
        }
    }
}
