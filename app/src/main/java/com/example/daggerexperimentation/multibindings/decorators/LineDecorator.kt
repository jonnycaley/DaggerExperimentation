package com.example.daggerexperimentation.multibindings.decorators

import com.example.daggerexperimentation.multibindings.StringDecorator

class LineDecorator: StringDecorator {
    override fun decorate(): (String) -> String = { string -> "---$string---"}
}