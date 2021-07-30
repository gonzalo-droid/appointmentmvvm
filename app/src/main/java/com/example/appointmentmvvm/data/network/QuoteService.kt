package com.example.appointmentmvvm.data.network

import com.example.appointmentmvvm.core.RetrofitHelper
import com.example.appointmentmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response
import retrofit2.create

class QuoteService {

    private  val retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getQuotes():List<QuoteModel>{
        //courrutina en hilo secundario
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllquotes()
            response.body() ?: emptyList() //en caso de null regresa lista empty
        }


    }
}