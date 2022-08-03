package com.example.sine_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sine_app.databinding.SelectAttendanceFragmentBinding
import com.example.sine_app.databinding.SelectServiceFragmentBinding

class SelectAttendanceFragment : Fragment() {

    lateinit var binding: SelectAttendanceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectAttendanceFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}