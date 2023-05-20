package com.example.rickandmortyapiandroid

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home_screen")
    object DetailScreen : Screens("detail_screen")
    object SignUpScreen : Screens("signup_screen")
    object SignInScreen : Screens("signip_screen")
    object DetailArgs : Screens("detailargs_screen")
}