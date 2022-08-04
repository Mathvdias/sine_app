package com.example.sine_app.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceAPI {

   @POST("ticket")
    suspend fun sendRequisition( @Body ticket: String) : Response<Ticket>
}