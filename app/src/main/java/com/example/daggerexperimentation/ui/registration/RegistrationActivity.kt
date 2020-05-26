package com.example.daggerexperimentation.ui.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.ui.registration.enterdetails.EnterDetailsFragment
import com.example.daggerexperimentation.ui.registration.termsandconditions.TermsAndConditionsFragment

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EnterDetailsFragment())
                .commitNow()
        }
    }

    fun navigateToTermsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TermsAndConditionsFragment())
            .commitNow()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, RegistrationActivity::class.java)
            context.startActivity(intent)
        }
    }
}
