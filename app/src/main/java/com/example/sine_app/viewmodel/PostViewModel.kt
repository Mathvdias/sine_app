package com.example.sine_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sine_app.model.ClientAPI
import kotlinx.coroutines.launch

class PostViewModel() : ViewModel() {


    val network = ClientAPI.getService()

    fun doPost(){
        viewModelScope.launch {
            try {
                network.sendRequisition("12")
            } catch (e : Exception){
                Log.e("Erro", e.message.toString())
            }
        }
    }
}