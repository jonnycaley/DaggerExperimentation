package com.example.daggerexperimentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.R
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (viewModel.hasUserRegistered())
            println("Registered")
        else
            println("Not Registered")
    }
}
