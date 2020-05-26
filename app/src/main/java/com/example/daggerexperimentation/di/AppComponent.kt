package com.example.daggerexperimentation.di

import android.content.Context
import com.example.daggerexperimentation.ui.main.MainActivity
import com.example.daggerexperimentation.ui.registration.enterdetails.EnterDetailsFragment
import com.example.daggerexperimentation.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: SplashActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(activity: MainActivity)
}