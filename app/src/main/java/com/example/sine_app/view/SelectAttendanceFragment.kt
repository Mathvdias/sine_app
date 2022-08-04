package com.example.sine_app.view

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
import com.example.sine_app.databinding.SelectAttendanceFragmentBinding
import com.sunmi.extprinterservice.ExtPrinterService
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
                val serviceConnection = object : ServiceConnection {
                    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                        val ext = ExtPrinterService.Stub.asInterface(p1)

                        ext.printText("\n\n\n")
                        ext.setAlignMode(1)
                        ext.printText("CARTEIRA DIGITAL")
                        ext.printText("\n")
                        ext.setFontZoom(2, 2)
                        ext.printText("2")
                        ext.printText("\n")
                        ext.printText("ACOMPANHE A FILA NO PAINEL DIGITAL")
                        ext.printText("\n\n\n\n\n\n\n\n")
                        ext.cutPaper(1, 1)
                    }

                    override fun onServiceDisconnected(p0: ComponentName?) {}

                }

                val intent = Intent()
                intent.setPackage("com.sunmi.extprinterservice")
                intent.action = "com.sunmi.extprinterservice.PrinterService"
                activity?.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            }

            digital3.setOnClickListener {
                Toast.makeText(requireContext(), "Opção 3", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_selectAttendanceFragment_to_finishFragment)
            }
        }
    }
}