package com.example.sine_app.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
import com.example.sine_app.databinding.FinishFragmentBinding

class FinishFragment : Fragment() {

    lateinit var binding: FinishFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FinishFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            try {
                findNavController().navigate(R.id.action_globalReturn)
            } catch (e : Exception){

            }
        }, 5000)
    }
}