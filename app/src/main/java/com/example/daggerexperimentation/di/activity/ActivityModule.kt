package com.example.daggerexperimentation.di.activity

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {
    /**
     * Dagger will generate a ActivityModule_ActivityNameProviderFactory
     * that will allow dagger to generate instance of the ActivityNameString
     * on demand
     */
    @ActivityNameString
    @Provides
    fun activityNameProvider(activity: Activity): String {
        return activity::class.java.name
    }
}
