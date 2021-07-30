package com.example.appointmentmvvm.domain

import com.example.appointmentmvvm.data.QuoteRepository
import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    private  val repository = QuoteRepository()

    operator fun invoke():QuoteModel? {
        val quotes = QuoteProvider.quotes


        if(!quotes.isNullOrEmpty()){
            val quoteListLength = quotes.size-1
//            val  randomNuber  = (0..quoteListLength).random()
            val  randomNuber  = (quotes.indices).random()
            return quotes[randomNuber]
        }
        return  null
    }
}