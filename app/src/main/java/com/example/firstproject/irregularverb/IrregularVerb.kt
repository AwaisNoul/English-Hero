package com.example.firstproject.irregularverb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.irregularverb.VideoEndWithT.VideoEndWithT

class IrregularVerb : AppCompatActivity() {

    private lateinit var recycler_view : RecyclerView
    private lateinit var c1 : CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_verb)
        window.statusBarColor = ContextCompat.getColor(this,R.color.statusbarcolor1)

        recycler_view = findViewById(R.id.recycler_view)
        c1 = findViewById(R.id.c1)

        c1.setOnClickListener {
            val intent = Intent(this,VideoEndWithT::class.java)
            startActivity(intent)
        }
    }
}


