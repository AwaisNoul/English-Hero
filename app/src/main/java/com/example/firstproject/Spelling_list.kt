package com.example.firstproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.alphabet.alphabet_view
import com.example.firstproject.digraph.Digraph

class Spelling_list : AppCompatActivity() {

    lateinit var alphabet : TextView
    lateinit var digraph : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spelling_list)
        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbarcolor)

        alphabet = findViewById(R.id.alphabet)
        digraph = findViewById(R.id.digraph)

        alphabet.setOnClickListener {
            val intent = Intent(this,alphabet_view::class.java)
            startActivity(intent)
        }

        digraph.setOnClickListener {
            val intent = Intent(this,Digraph::class.java)
            startActivity(intent)
        }
    }
}