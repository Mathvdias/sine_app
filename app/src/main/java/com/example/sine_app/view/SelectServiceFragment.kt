package com.example.sine_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
import com.example.sine_app.databinding.SelectServiceFragmentBinding

class SelectServiceFragment : Fragment() {

    lateinit var binding: SelectServiceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectServiceFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.linear.setOnClickListener {
            findNavController().navigate(R.id.action_selectServiceFragment_to_selectAttendanceFragment)
        }
    }
}