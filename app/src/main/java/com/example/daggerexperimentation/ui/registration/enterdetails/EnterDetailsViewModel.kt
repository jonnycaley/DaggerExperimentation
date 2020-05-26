package com.example.daggerexperimentation.ui.registration.enterdetails

import androidx.lifecycle.ViewModel
import com.example.daggerexperimentation.di.UserManager
import javax.inject.Inject

class EnterDetailsViewModel @Inject constructor(
    private val userManager: UserManager
) : ViewModel() {

    fun registerUser(username: String, password: String) {
        userManager.registerUser(username, password)
    }
}
