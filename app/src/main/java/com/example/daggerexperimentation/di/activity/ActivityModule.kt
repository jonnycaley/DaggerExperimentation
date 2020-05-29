package com.example.daggerexperimentation.di.activity

import android.app.Activity
import android.content.Context
import com.example.daggerexperimentation.di.ActivityScope
import com.example.daggerexperimentation.di.StringDecorator
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun providesStringDecorator(context: Context): StringDecorator {
        return StringDecorator(context)
    }

    @ActivityNameString
    @Provides
    fun stringProvider(activity: Activity): String {
        return activity::class.java.name
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ActivityNameString
