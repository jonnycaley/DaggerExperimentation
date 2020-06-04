package com.example.daggerexperimentation

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.example.daggerexperimentation.explanations.app.AppComponent
import com.example.daggerexperimentation.explanations.app.DaggerAppComponent
import com.example.daggerexperimentation.multibindings.StringDecorator
import javax.inject.Inject

open class MyApplication : Application() {

    @Inject
    lateinit var pref: SharedPreferences

    @Inject
    @JvmSuppressWildcards(true)
    lateinit var decorators: Set<StringDecorator>

    open val component: AppComponent by lazy {
        DaggerAppComponent.factory().build(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()

        val string = "Plain old string"

        decorators.forEach {
            Log.i("Look at this string!", it.decorate().invoke(string))
        }
    }
}