package com.example.daggerexperimentation.ui.splash

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {

    fun hasUserRegistered(): Boolean {
        return false
    }
}