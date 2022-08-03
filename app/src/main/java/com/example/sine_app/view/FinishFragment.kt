package com.example.sine_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
}