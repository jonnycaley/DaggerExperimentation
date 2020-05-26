package com.example.daggerexperimentation.di

import com.example.daggerexperimentation.ui.main.MainActivity
import com.example.daggerexperimentation.ui.registration.enterdetails.EnterDetailsFragment
import com.example.daggerexperimentation.ui.splash.SplashActivity
import dagger.Component

@Component
interface AppComponent {

    fun inject(activity: SplashActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(activity: MainActivity)
}