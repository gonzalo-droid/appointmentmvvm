package com.example.appointmentmvvm.data

import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider
import com.example.appointmentmvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        //call backend
        val response:List<QuoteModel> = api.getQuotes()
        // simular save en memory
        QuoteProvider.quotes = response

        return response
    }
}