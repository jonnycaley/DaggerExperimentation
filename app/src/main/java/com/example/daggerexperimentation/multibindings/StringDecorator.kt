package com.example.daggerexperimentation.multibindings

interface StringDecorator {
    fun decorate(): (String) -> String
}