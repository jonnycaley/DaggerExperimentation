package com.example.daggerexperimentation

import android.app.Application
import com.example.daggerexperimentation.di.AppComponent
import com.example.daggerexperimentation.di.DaggerAppComponent

open class MyApplication : Application() {
    open val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}