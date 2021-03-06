package com.example.appointmentmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.appointmentmvvm.databinding.ActivityMainBinding
import com.example.appointmentmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    // implementation "androidx.activity:activity-ktx:1.2.2"
    //conexion del viewmodel al activity
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })


        //processbar active
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })


        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}