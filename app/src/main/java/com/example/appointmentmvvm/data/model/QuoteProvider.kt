package com.example.appointmentmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
//    companion object {
        var quotes:List<QuoteModel> = emptyList()
//        fun random():QuoteModel{
//            return quote[(0..10).random()]
//        }
//        val quote = listOf<QuoteModel>(
//            QuoteModel(
//                quote = "It’s not a bug. It’s an undocumented feature!",
//                author = "Anonymous"
//            ),
//
//        )
//    }

}