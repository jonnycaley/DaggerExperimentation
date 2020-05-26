package com.example.daggerexperimentation.di

import android.content.Context
import javax.inject.Inject

class PreferencesManager @Inject constructor(context: Context) {

    private val preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE)

    fun setString(key: String, value: String) {
        with(preferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String): String {
        return preferences.getString(key, "")!!
    }
}