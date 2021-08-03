package com.example.appointmentmvvm.domain

import com.example.appointmentmvvm.data.QuoteRepository
import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private  val repository: QuoteRepository ){

//    private  val repository = QuoteRepository()

    suspend operator fun invoke():QuoteModel?{
        return repository.getRandomQuote();
    }
    /*
    operator fun invoke():QuoteModel? {
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val quoteListLength = quotes.size-1
            // val  randomNuber  = (0..quoteListLength).random()
            val  randomNuber  = (quotes.indices).random()
            return quotes[randomNuber]
        }
        return  null
    }
    */

}