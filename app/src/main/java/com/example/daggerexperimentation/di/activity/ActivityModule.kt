package com.example.daggerexperimentation.di.activity

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @ActivityNameString
    @Provides
    fun stringProvider(activity: Activity): String {
        return activity::class.java.name
    }
}
