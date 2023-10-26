package com.example.firstproject.digraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.R

class EI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ei)
        window.statusBarColor= ContextCompat.getColor(this,R.color.skyblue)

    }
}