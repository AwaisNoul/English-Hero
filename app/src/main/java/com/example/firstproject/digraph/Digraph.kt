package com.example.firstproject.digraph

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Digraph : AppCompatActivity() {

    private lateinit var ei: TextView
    private lateinit var quiz: TextView
    private lateinit var actionbutton : FloatingActionButton
    private val address = "Order/Simple/present"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digraph)

        ei = findViewById(R.id.ei)
        quiz = findViewById(R.id.quiz)

        ei.setOnClickListener {
            val intent = Intent(this, EI::class.java)
            startActivity(intent)
        }

        quiz.setOnClickListener {
            val intent = Intent(this, QuizView::class.java)
            startActivity(intent)
        }
    }
}