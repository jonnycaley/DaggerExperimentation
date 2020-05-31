package com.example.daggerexperimentation.di.componentdependenciesVSsubcomponent.subcomponent

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerexperimentation.di.componentdependenciesVSsubcomponent.componentdependency.Dependency1
import com.example.daggerexperimentation.di.componentdependenciesVSsubcomponent.componentdependency.Dependency2
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

    /**
     * We have to declare the subcomponents of BaseComponent in a
     * module (SubComponentModule)
     */
    @Component(modules = [BaseModule::class, SubComponentModule::class])
    interface BaseComponent {
        fun inject(application: ExampleApplication)

        /**
         * We expose LoginComponent's factory
         * to access it from out activity
         */
        fun loginSubComponent(): LoginComponent.Factory
    }

    @Module
    object BaseModule {
        @Provides
        fun providesDependency1(): Dependency1 = Dependency1()

        @Provides
        fun providesDependency2(): Dependency2 = Dependency2()
    }

    /**
     * We declare the subcomponents of BaseComponent inside
     * SubComponentModule
     */
    @Module(subcomponents = [LoginComponent::class])
    class SubComponentModule

    @Subcomponent
    interface LoginComponent {
        fun inject(activity: SplashActivity)

        /**
         * We have to declare a factory so the subcomponent
         * can be exposed in BaseComponent for injection in Activities
         */
        @Subcomponent.Factory
        interface Factory {
            fun build(): LoginComponent
        }
    }


    class ExampleApplication: Application() {
        val component: BaseComponent by lazy { DaggerBaseComponent.create() }
    }

    class SplashActivity: AppCompatActivity() {
        /**
         * As LoginSubComponent is a SubComponent of BaseComponent
         * it has access to all of its provided dependencies without
         * requiring methods to expose them like in ComponentDependencies.kt
         */
        @Inject
        lateinit var dependency1: Dependency1

        @Inject
        lateinit var dependency2: Dependency2

        override fun onCreate(savedInstanceState: Bundle?) {
            /**
             * Access the subcomponent factory declared in BaseComponent
             */
            val baseComponent = (application as ExampleApplication).component
            baseComponent.loginSubComponent().build().inject(this)
            super.onCreate(savedInstanceState)
        }
    }