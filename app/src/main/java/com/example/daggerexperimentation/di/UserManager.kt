package com.example.daggerexperimentation.di

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    val context: Context
) {
    var username: String? = null
    var password: String? = null

    fun registerUser(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun unRegisterUser() {
        username = null
        password = null
    }

    fun isUserLoggedIn(): Boolean {
        return (username != null && password != null)
    }
}