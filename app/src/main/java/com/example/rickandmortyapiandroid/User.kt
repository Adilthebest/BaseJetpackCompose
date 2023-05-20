package com.example.rickandmortyapiandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val number: String?,
    val password: String?,
    val email: String?,
    val confimPassword: String?,
):Parcelable
