package com.example.daggerexperimentation.ui.registration.enterdetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerexperimentation.MyApplication
import com.example.daggerexperimentation.R
import kotlinx.android.synthetic.main.enter_details_fragment.*
import javax.inject.Inject

class EnterDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModel: EnterDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.enter_details_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).component.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_register.setOnClickListener {
            val userName = edittext_username.text.toString().trim()
            val password = edittext_password.text.toString()

            if (viewModel.areDetailsAcceptable(userName, password))
                viewModel.registerUser(userName, password)
        }
    }
}
