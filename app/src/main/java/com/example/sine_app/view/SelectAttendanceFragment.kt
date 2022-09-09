package com.example.sine_app.view

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.sine_app.R
import com.example.sine_app.databinding.SelectAttendanceFragmentBinding
import com.sunmi.extprinterservice.ExtPrinterService
import com.example.sine_app.util.CounterTicketNumber
import com.example.sine_app.viewmodel.PostViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

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

        var viewModel = ViewModelProvider(requireActivity())[PostViewModel::class.java]

        suspend fun sendTicket(numberTicket : Int){
            viewModel.doPost(numberTicket)
        }

        binding.apply {
            cardViewTest.setOnClickListener {
             printer(++CounterTicketNumber.registerSine, "Cadastro no Sine Manaus")
                GlobalScope.launch {
                    sendTicket(CounterTicketNumber.registerSine)
                }
                Toast.makeText(requireContext(), "Opção 1", Toast.LENGTH_SHORT).show()
                checkCurrentFragment()
            }

            digitalView.setOnClickListener {
                printer(++CounterTicketNumber.digitalWallet, "Carteira Digital")
                GlobalScope.launch {
                    sendTicket(CounterTicketNumber.digitalWallet)
                }
                Toast.makeText(requireContext(), "Opção 2", Toast.LENGTH_SHORT).show()
                checkCurrentFragment()
            }

            digital3.setOnClickListener {
                printer(++CounterTicketNumber.securityJob, "Seguro-Desemprego")
                GlobalScope.launch {
                    sendTicket(CounterTicketNumber.securityJob)
                }
                Toast.makeText(requireContext(), "Opção 3", Toast.LENGTH_SHORT).show()
                checkCurrentFragment()
            }
        }
    }


    private fun checkCurrentFragment(){
        val currentFragment = NavHostFragment.findNavController(this@SelectAttendanceFragment).currentDestination?.id

        currentFragment?.let {it
            if(it==R.id.selectAttendanceFragment){
                Log.e(" merda", it.toString())
                findNavController().navigate(R.id.action_selectAttendanceFragment_to_finishFragment)
            }

        }
    }
    fun printer (ticketNumber : Int, serviceName : String){
        val serviceConnection = object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                val ext = ExtPrinterService.Stub.asInterface(p1)

                ext.printText("\n\n\n")
                ext.setAlignMode(1)
                ext.setFontZoom(2, 2)
                ext.printText(serviceName)
                ext.printText("\n\n\n\n")

                ext.setFontZoom(5, 5)

                ext.printText( ticketNumber.toString() )

                ext.setFontZoom(1, 2)
                ext.printText("\n\n\n\n")
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
}