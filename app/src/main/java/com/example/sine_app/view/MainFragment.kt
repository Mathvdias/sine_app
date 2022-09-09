package com.example.sine_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
import com.example.sine_app.databinding.FragmentMainBinding
import com.example.sine_app.model.Ticket
import com.example.sine_app.viewmodel.PostViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    lateinit var viewModel : PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(requireActivity())[PostViewModel::class.java]


//       GlobalScope.launch {
//           sendTicket()
//       }

        binding.linear.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_selectServiceFragment)
        }
    }

//    suspend fun sendTicket(){
//        viewModel.doPost(25)
//    }
}