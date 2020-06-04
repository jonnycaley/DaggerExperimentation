package com.example.daggerexperimentation.multibindings.decorators

import com.example.daggerexperimentation.multibindings.StringDecorator

class DotDecorator: StringDecorator {
    override fun decorate(): (String) -> String = { string -> "•••$string•••"}
}