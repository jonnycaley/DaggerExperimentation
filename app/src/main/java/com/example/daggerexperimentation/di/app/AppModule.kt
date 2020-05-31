package com.example.daggerexperimentation.di.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.daggerexperimentation.MyApplication
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