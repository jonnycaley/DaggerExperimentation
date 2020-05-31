package com.example.daggerexperimentation.di.activity

import javax.inject.Scope

/**
 * Defines the scope of the dependencies for ActivityComponent
 * AS @Singleton is uses in ActivityComponent a new scope must
 * be defined
 */
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope