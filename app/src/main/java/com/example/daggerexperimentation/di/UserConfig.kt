package com.example.daggerexperimentation.di

import javax.inject.Inject

class UserConfig @Inject constructor() {

    var hasUserRegistered = false

    fun registerUser() {
        hasUserRegistered = true
    }

    fun unRegisterUser() {
        hasUserRegistered = false
    }
}