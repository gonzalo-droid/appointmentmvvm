package com.example.appointmentmvvm.data.network

import com.example.appointmentmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllquotes():Response<List<QuoteModel>>
}