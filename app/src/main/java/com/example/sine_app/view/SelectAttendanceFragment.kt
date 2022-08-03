package com.example.sine_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            cardViewTest.setOnClickListener {
                Toast.makeText(requireContext(), "Opção 1", Toast.LENGTH_SHORT).show()
            }

            digitalView.setOnClickListener {
                Toast.makeText(requireContext(), "Opção 2", Toast.LENGTH_SHORT).show()
            }

            digital3.setOnClickListener {
                Toast.makeText(requireContext(), "Opção 3", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_selectAttendanceFragment_to_finishFragment)
            }
        }
    }
}