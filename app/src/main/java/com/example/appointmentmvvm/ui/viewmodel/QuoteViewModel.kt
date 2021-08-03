package com.example.appointmentmvvm.ui.viewmodel

import android.text.GetChars
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appointmentmvvm.data.model.QuoteModel
import com.example.appointmentmvvm.data.model.QuoteProvider
import com.example.appointmentmvvm.domain.GetQuoteUseCase
import com.example.appointmentmvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase : GetQuoteUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase
): ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

//    var getQuoteUseCase = GetQuoteUseCase()
//    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        //courrita
        viewModelScope.launch {

            isLoading.postValue(true)

            val result:List<QuoteModel>? = getQuoteUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }


        }
    }

    fun randomQuote(){

        viewModelScope.launch {
            isLoading.postValue(true)

            val quote:QuoteModel? = getRandomQuoteUseCase()

            if(quote!=null){
                quoteModel.postValue(quote!!)
            }

            isLoading.postValue(false)
        }



        //call to new quote
        //val currentQuote: QuoteModel = QuoteProvider.random()

        //assigment new quote live data
        //quoteModel.postValue(currentQuote)
    }


}