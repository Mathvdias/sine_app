package com.example.sine_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sine_app.model.ClientAPI
import com.example.sine_app.model.Ticket
import kotlinx.coroutines.launch

class PostViewModel() : ViewModel() {


    val network = ClientAPI.getService()

   suspend fun doPost(ticket: Int){
        viewModelScope.launch {
            try {
                network.sendRequisition(Ticket(ticket))
            } catch (e : Exception){
                Log.e("Erro", e.message.toString())
            }
        }
    }
}