package com.example.daggerexperimentation.ui.main

import androidx.lifecycle.ViewModel
import com.example.daggerexperimentation.di.UserManager
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userManager: UserManager
) : ViewModel() {

    fun getUserName(): String? = userManager.username
    fun unRegisterUser() {
        userManager.unRegisterUser()
    }
}