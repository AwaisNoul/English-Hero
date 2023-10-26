package com.example.firstproject.alphabet

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstproject.R

class alphabet_view : AppCompatActivity() {

    lateinit var alphabet :TextView
    lateinit var spelling_letter :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_view)

        alphabet = findViewById(R.id.alphabet)
        spelling_letter = findViewById(R.id.spelling_letter)

        alphabet.setOnClickListener {
            val intent = Intent(this,Alphabet_rec::class.java)
            startActivity(intent)
        }

        spelling_letter.setOnClickListener {
            val intent = Intent(this,SpellingLetter::class.java)
            startActivity(intent)
        }
    }
}