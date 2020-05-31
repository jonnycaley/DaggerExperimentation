package com.example.daggerexperimentation.di.app

import android.app.Application
import android.content.SharedPreferences
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.di.activity.ActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
/**
 * Dagger will create a implementation of this component called DaggerAppComponent
 */
interface AppComponent {
    /**
     * DaggerAppComponent will contain an implementation of this factory that
     * will allow you to build an instance of DaggerAppComponent
     * ***This will be the gateway in from your code***
     */
    @Component.Factory
    interface Factory {
        fun build(@BindsInstance app: Application): AppComponent
    }

    /**
     * For components that are dependencies of this component (as opposed to
     * subcomponents of this component), we have to explicitly declare that
     * we want them to have access to these dependencies through functions
     */
    fun preferences(): SharedPreferences

    /**
     * DaggerAppComponent will use the injected class's generated members injector
     * class (MyApplication_MembersInjector) to inject its field dependencies into the instance
     * of MyApplication using the dependencies corresponding factories generated by dagger
     */
    fun inject(application: MyApplication)
}