package com.example.daggerexperimentation.di

import android.content.Context
import com.example.daggerexperimentation.R

class StringDecorator(private val context: Context) {

    fun decorateString(string: String): String {
        val decoration = context.getString(R.string.decoration)
        return decoration + string + decoration
    }

}