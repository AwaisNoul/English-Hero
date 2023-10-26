package com.example.firstproject.digraph

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstproject.R

class Digraph : AppCompatActivity() {

    private lateinit var ei: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digraph)

        ei = findViewById(R.id.ei)

        ei.setOnClickListener {

            val intent = Intent(this, EI::class.java)
            startActivity(intent)

        }
    }
}