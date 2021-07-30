package com.example.appointmentmvvm.domain

import com.example.appointmentmvvm.data.QuoteRepository
import com.example.appointmentmvvm.data.model.QuoteModel

class GetQuoteUseCase {

    private  val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}