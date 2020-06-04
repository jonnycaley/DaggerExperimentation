package com.example.daggerexperimentation.multibindings

import com.example.daggerexperimentation.multibindings.decorators.DotDecorator
import com.example.daggerexperimentation.multibindings.decorators.LineDecorator
import com.example.daggerexperimentation.multibindings.decorators.StarDecorator
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
object MultibindingsModule {

    @Provides
    @IntoSet
    fun provideLineDecorator(): StringDecorator = LineDecorator()

    @Provides
    @ElementsIntoSet
    fun providesRemainderDecorators(): Set<StringDecorator> = setOf(
        DotDecorator(),
        StarDecorator()
    )
}