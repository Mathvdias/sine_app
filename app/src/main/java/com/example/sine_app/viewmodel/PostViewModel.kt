package com.example.sine_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sine_app.model.ClientAPI
import com.example.sine_app.model.Ticket
import kotlinx.coroutines.launch

class PostViewModel() : ViewModel() {


    val network = ClientAPI.getService()

    fun doPost(){
        viewModelScope.launch {
            try {
                network.sendRequisition(Ticket(75))
            } catch (e : Exception){
                Log.e("Erro", e.message.toString())
            }
        }
    }
}