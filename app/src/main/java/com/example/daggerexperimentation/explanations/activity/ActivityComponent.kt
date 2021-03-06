package com.example.daggerexperimentation.explanations.activity

import android.app.Activity
import com.example.daggerexperimentation.explanations.app.AppComponent
import com.example.daggerexperimentation.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
/**
 * Dagger will create a implementation of this component called DaggerActivityComponent
 */
interface ActivityComponent {
    /**
     * DaggerActivityComponent will contain an implementation of this factory that
     * will allow you to build an instance of DaggerActivityComponent
     * ***This will be the gateway in from your code***
     */
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            appComponent: AppComponent
        ): ActivityComponent
    }

    /**
     * DaggerActivityComponent will use the injected class's generated members injector
     * class (MainActivity_MembersInjector) to inject its field dependencies into the instance
     * of MainActivity using the dependencies corresponding factories generated by dagger
     */
    fun inject(activity: MainActivity)
}