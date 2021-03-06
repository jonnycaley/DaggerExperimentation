package com.example.daggerexperimentation.componentdependenciesVSsubcomponent.componentdependency

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
    @Component(modules = [MainComponentModule::class])
    interface MainComponent {
        /**
         * Expose Dependency1 from MainComponentModule only,
         * Dependency2 stays hidden from other components
         * that declare this component as a dependency
         */
        fun exposeDependency1(): Dependency1
    }

    @Module
    object MainComponentModule {
        @Provides
        fun provideDependency1(): Dependency1 = Dependency1()

        @Provides
        fun provideDependency2(): Dependency2 = Dependency2()
    }

    class Dependency1
    class Dependency2

    /**
     * We declare MainComponent to be a dependency of DependentComponent
     */
    @Component(dependencies = [MainComponent::class])
    interface DependentComponent {

        /**
         * DependentComponent depends on MainComponent therefore
         * we have to provide MainComponent when building
         * DependentComponent for injection
         */
        @Component.Factory
        interface Factory {
            fun build(
                @BindsInstance activity: Activity,
                mainComponent: MainComponent
            ): DependentComponent
        }

        fun inject(activity: DependentActivity)
    }

    class MainApplication: Application() {
        val component: MainComponent by lazy { DaggerMainComponent.create() }
    }

    class DependentActivity: AppCompatActivity() {
        /**
         * Because we exposed Dependency1 inside MainComponent
         * we can access it from components that declare
         * MainComponent as a dependency
         */
        @Inject
        lateinit var exposedDependency: Dependency1

        /**
         * Dependency2 isn't exposed using a MainComponent function
         * and is therefore not accessible for DependentActivity
         */
    //    @Inject
    //    lateinit var dependency2: Dependency2

        override fun onCreate(savedInstanceState: Bundle?) {
            val component = (application as MainApplication).component
            DaggerDependentComponent.factory()
                .build(this, component).inject(this)
            super.onCreate(savedInstanceState)
        }
    }