package com.example.mviapp.presention.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mviapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}