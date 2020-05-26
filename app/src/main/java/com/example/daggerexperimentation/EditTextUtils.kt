package com.example.daggerexperimentation

object EditTextUtils {
    fun areDetailsAcceptable(username: String, password: String): Boolean {
        return ((username.length > 4) && (password.length > 4))
    }
}