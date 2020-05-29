package com.example.daggerexperimentation.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

}