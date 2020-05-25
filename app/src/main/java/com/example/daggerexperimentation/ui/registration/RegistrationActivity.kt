package com.example.daggerexperimentation.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.ui.registration.enterdetails.EnterDetailsFragment

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EnterDetailsFragment.newInstance())
                .commitNow()
        }
    }
}
