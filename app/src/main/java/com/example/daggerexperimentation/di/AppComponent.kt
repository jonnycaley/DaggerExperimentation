package com.example.daggerexperimentation.di

import android.content.Context
import com.example.daggerexperimentation.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {

    fun inject(activity: SplashActivity)
}