package com.example.daggerexperimentation.ui.main

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.di.StringDecorator
import com.example.daggerexperimentation.di.activity.ActivityNameString
import com.example.daggerexperimentation.di.activity.DaggerActivityComponent
import com.example.daggerexperimentation.di.app.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @ActivityNameString
    @Inject
    lateinit var activityName: String

    @Inject
    lateinit var foo: String

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = (application as MyApplication).component
        DaggerActivityComponent.factory().create(this, "Foo", appComponent).inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview.text = "$activityName $foo"

        sharedPreferences
    }

    companion object {
        fun create(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
