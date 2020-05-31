package com.example.daggerexperimentation.explanations.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideContext(app: Application): Context {
        return app
    }
}