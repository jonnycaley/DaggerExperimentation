package com.example.daggerexperimentation

import android.app.Application
import android.content.SharedPreferences
import com.example.daggerexperimentation.explanations.app.AppComponent
import com.example.daggerexperimentation.explanations.app.DaggerAppComponent
import javax.inject.Inject

open class MyApplication : Application() {

    @Inject
    lateinit var pref: SharedPreferences

    open val component: AppComponent by lazy {
        DaggerAppComponent.factory().build(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}