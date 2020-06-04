package com.example.daggerexperimentation.explanations.activity

import javax.inject.Scope

/**
 * Defines the scope of the dependencies for ActivityComponent
 * AS @Singleton is uses in ActivityComponent a new scope must
 * be defined
 */
@Scope
/**
 * [MustBeDocumented] Informs tools that this should be part of
 * the JavaDocs
 */
@MustBeDocumented
/**
 * [Retention] Informs the compiler the level of persistence of
 * the annotation during the build execution. Runtime means the
 * annotation persists up until the exucution of the code you
 * annotated
 */
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope