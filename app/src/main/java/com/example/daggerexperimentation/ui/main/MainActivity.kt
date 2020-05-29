package com.example.daggerexperimentation.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.di.StringDecorator
import com.example.daggerexperimentation.di.activity.ActivityNameString
import com.example.daggerexperimentation.di.activity.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var decorator: StringDecorator
//
//    @Inject
//    lateinit var viewModel: MainViewModel

    @ActivityNameString
    @Inject
    lateinit var activityName: String

    @Inject
    lateinit var foo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerActivityComponent.factory().create(this, "Foo").inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview.text = "$activityName $foo"
    }

    companion object {
        fun create(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
