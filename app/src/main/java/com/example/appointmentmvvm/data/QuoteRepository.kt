package com.example.appointmentmvvm.data

import android.util.Log
import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider
import com.example.appointmentmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService){
//    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        //call backend
        val response:List<QuoteModel> = api.getQuotes()
        // simular save en memory
//        QuoteProvider.quotes = response
        Log.i("lista",response.toString());
        return response
    }

    suspend fun getRandomQuote():QuoteModel?{
        val response:List<QuoteModel> = api.getQuotes()
        //call backend
        if(!response.isNullOrEmpty()){
            val quoteListLength = response.size-1
            // val  randomNuber  = (0..quoteListLength).random()
            val  randomNuber  = (response.indices).random()
            return response[randomNuber]
        }
        return  null
    }


}