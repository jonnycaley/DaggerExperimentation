package com.example.daggerexperimentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.ui.login.LoginActivity
import com.example.daggerexperimentation.ui.registration.RegistrationActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread.sleep(2000)

        if (viewModel.hasUserRegistered())
            LoginActivity.start(this)
        else
            RegistrationActivity.start(this)
    }
}
