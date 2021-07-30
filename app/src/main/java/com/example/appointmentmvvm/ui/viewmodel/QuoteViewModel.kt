package com.example.appointmentmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider
import com.example.appointmentmvvm.domain.GetQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    val getQuoteUseCase = GetQuoteUseCase()

    fun onCreate() {
        //courrita
        viewModelScope.launch {
            val result:List<QuoteModel>? = getQuoteUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
        //call to new quote
//        val currentQuote: QuoteModel = QuoteProvider.random()
        //assigment new quote live data
//        quoteModel.postValue(currentQuote)
    }


}