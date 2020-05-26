package com.example.daggerexperimentation.ui.splash

import androidx.lifecycle.ViewModel
import com.example.daggerexperimentation.di.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userManager: UserManager
) : ViewModel() {

    fun hasUserRegistered(): Boolean {
        return userManager.isUserRegistered()
    }
}