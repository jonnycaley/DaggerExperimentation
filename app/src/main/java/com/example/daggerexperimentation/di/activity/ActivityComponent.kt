package com.example.daggerexperimentation.di.activity

import android.app.Activity
import com.example.daggerexperimentation.di.ActivityScope
import com.example.daggerexperimentation.ui.main.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            @BindsInstance string: String
        ): ActivityComponent
    }

    fun inject(activity: MainActivity)
}