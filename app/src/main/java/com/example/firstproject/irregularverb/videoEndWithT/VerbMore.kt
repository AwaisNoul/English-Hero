package com.example.firstproject.irregularverb.videoEndWithT

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firstproject.R

class VerbMore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb_more)

        val intent = getIntent().getStringExtra("msj")
        val third_form = findViewById<TextView>(R.id.third_form)
        third_form.text = intent.toString()
    }
}