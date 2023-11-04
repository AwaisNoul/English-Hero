package com.example.firstproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.irregularverb.IrregularListActivity

class MainActivity : AppCompatActivity() {

    lateinit var egg1 : ImageView
    lateinit var egg3 : ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor= ContextCompat.getColor(this,R.color.statusbarcolor)

        egg1 = findViewById(R.id.egg1)
        egg3 = findViewById(R.id.egg3)

        egg1.setOnClickListener{
            val intent = Intent(this,Spelling_list::class.java)
            startActivity(intent)
        }

        egg3.setOnClickListener{
            val intent = Intent(this, IrregularListActivity::class.java)
            startActivity(intent)
        }

    }
}