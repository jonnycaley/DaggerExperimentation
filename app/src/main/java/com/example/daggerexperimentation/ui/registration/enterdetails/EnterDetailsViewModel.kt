package com.example.daggerexperimentation.ui.registration.enterdetails

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class EnterDetailsViewModel @Inject constructor() : ViewModel() {

    fun areDetailsAcceptable(username: String, password: String): Boolean {
        return ((username.length > 4) && (password.length > 4))
    }
}
