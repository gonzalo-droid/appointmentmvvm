package com.example.appointmentmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appointmentmvvm.model.QuoteModel
import com.example.appointmentmvvm.model.QuoteProvider

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        //call to new quote
        val currentQuote: QuoteModel = QuoteProvider.random()
        //assigment new quote live data
        quoteModel.postValue(currentQuote)
    }
}