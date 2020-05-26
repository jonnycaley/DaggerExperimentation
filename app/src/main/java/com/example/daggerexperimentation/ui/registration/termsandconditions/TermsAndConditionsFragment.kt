package com.example.daggerexperimentation.ui.registration.termsandconditions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider
import com.example.daggerexperimentation.R
import com.example.daggerexperimentation.ui.main.MainActivity
import com.example.daggerexperimentation.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.terms_and_conditions_fragment.*

class TermsAndConditionsFragment : Fragment() {
    private lateinit var viewModel: TermsAndConditionsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.terms_and_conditions_fragment, container, false)
        view.findViewById<CheckBox>(R.id.checkbox_terms).setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                button_accept.visibility = View.VISIBLE
            else
                button_accept.visibility = View.GONE
        }
        view.findViewById<Button>(R.id.button_accept).setOnClickListener {
            MainActivity.create(it.context)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TermsAndConditionsViewModel::class.java)
    }
}
