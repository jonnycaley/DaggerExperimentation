package com.example.daggerexperimentation.ui.splash

import androidx.lifecycle.ViewModel
import com.example.daggerexperimentation.di.UserConfig
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userConfig: UserConfig
) : ViewModel() {

    fun hasUserRegistered(): Boolean {
        return userConfig.hasUserRegistered
    }
}