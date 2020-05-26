package com.example.daggerexperimentation.di

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    private val preferencesManager: PreferencesManager
) {

    fun registerUser(username: String, password: String) {
        preferencesManager.setString(KEYS.USERNAME.key, username)
        preferencesManager.setString(KEYS.PASSWORD.key, password)
    }

    fun unRegisterUser() {
        preferencesManager.setString(KEYS.USERNAME.key, "")
        preferencesManager.setString(KEYS.PASSWORD.key, "")
    }

    fun isUserRegistered(): Boolean {
        val username = preferencesManager.getString(KEYS.USERNAME.key)
        val password = preferencesManager.getString(KEYS.PASSWORD.key)
        return (username != "" && password != "")
    }

    fun getUsername(): String? {
        return preferencesManager.getString(KEYS.USERNAME.key)
    }

    enum class KEYS(val key: String) {
        USERNAME("username"),
        PASSWORD("password")
    }
}