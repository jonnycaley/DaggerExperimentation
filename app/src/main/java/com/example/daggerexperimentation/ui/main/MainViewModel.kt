package com.example.daggerexperimentation.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.daggerexperimentation.di.activity.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Dagger will generate factories for dependencies annotated with @Inject.
 * These factories will then be used by the dagger generated component (DaggerActivityComponent)
 * to inject the dependency into an instance of the activity using the activities corresponding
 * generated MembersInjector class
 */
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel()