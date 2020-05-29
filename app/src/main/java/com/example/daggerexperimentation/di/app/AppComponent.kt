package com.example.daggerexperimentation.di.app

import android.app.Application
import android.content.SharedPreferences
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.di.SubComponentsModule
import com.example.daggerexperimentation.di.activity.ActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, SubComponentsModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun build(@BindsInstance app: Application): AppComponent
    }

    fun activityComponent(): ActivityComponent.Factory

    fun inject(application: MyApplication)
}