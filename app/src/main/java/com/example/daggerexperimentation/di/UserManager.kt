package com.example.daggerexperimentation.di

import javax.inject.Inject

class UserManager @Inject constructor() {
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