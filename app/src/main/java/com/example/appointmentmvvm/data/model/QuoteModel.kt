package com.example.appointmentmvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("quota") val quote:String,@SerializedName("author") val author:String)