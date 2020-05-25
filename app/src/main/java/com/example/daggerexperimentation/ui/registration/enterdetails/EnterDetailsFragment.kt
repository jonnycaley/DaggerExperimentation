package com.example.daggerexperimentation.ui.registration.enterdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.daggerexperimentation.R

class EnterDetailsFragment : Fragment() {
    companion object {
        fun newInstance() = EnterDetailsFragment()
    }

    private lateinit var viewModel: EnterDetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.enter_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EnterDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
