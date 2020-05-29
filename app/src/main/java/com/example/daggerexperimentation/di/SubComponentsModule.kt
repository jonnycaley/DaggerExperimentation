package com.example.daggerexperimentation.di

import com.example.daggerexperimentation.di.activity.ActivityComponent
import dagger.Module

@Module(subcomponents = [ActivityComponent::class])
class SubComponentsModule