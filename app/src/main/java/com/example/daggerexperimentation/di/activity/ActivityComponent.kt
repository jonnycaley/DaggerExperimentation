package com.example.daggerexperimentation.di.activity

import android.app.Activity
import com.example.daggerexperimentation.di.ActivityScope
import com.example.daggerexperimentation.di.app.AppComponent
import com.example.daggerexperimentation.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            @BindsInstance string: String,
            appComponent: AppComponent
        ): ActivityComponent
    }

    fun inject(activity: MainActivity)
}