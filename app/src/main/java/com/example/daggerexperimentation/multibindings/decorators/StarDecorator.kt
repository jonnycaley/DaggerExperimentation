package com.example.daggerexperimentation.multibindings.decorators

import com.example.daggerexperimentation.multibindings.StringDecorator

class StarDecorator: StringDecorator {
    override fun decorate(): (String) -> String  = { string -> "***$string***" }
}