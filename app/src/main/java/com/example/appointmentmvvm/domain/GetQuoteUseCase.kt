package com.example.appointmentmvvm.domain

import com.example.appointmentmvvm.data.QuoteRepository
import com.example.appointmentmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

//    private  val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}