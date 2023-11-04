package com.example.firstproject.digraph

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.R

class EI : AppCompatActivity() {

    private lateinit var by: TextView
    private lateinit var cry: TextView
    private lateinit var fry: TextView
    private lateinit var light: TextView
    private lateinit var sight: TextView
    private lateinit var right: TextView
    private lateinit var lie: TextView
    private lateinit var die: TextView
    private lateinit var pie: TextView
    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ei)
        window.statusBarColor = ContextCompat.getColor(this, R.color.skyblue)

        by = findViewById(R.id.by)
        cry = findViewById(R.id.cry)
        fry = findViewById(R.id.fry)
        light = findViewById(R.id.light)
        sight = findViewById(R.id.sight)
        right = findViewById(R.id.right)
        lie = findViewById(R.id.lie)
        die = findViewById(R.id.die)
        pie = findViewById(R.id.pie)

        val commonClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.by -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.by)
                    mediaPlayer?.start()
                }

                R.id.cry -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.cry)
                    mediaPlayer?.start()
                }

                R.id.fry -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.fry)
                    mediaPlayer?.start()
                }

                R.id.light -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.light)
                    mediaPlayer?.start()
                }

                R.id.sight -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.sight)
                    mediaPlayer?.start()
                }

                R.id.right -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.right)
                    mediaPlayer?.start()
                }

                R.id.lie -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.lie)
                    mediaPlayer?.start()
                }

                R.id.die -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.die)
                    mediaPlayer?.start()
                }

                R.id.pie -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.pie)
                    mediaPlayer?.start()
                }
            }
        }

        by.setOnClickListener(commonClickListener)
        cry.setOnClickListener(commonClickListener)
        fry.setOnClickListener(commonClickListener)
        light.setOnClickListener(commonClickListener)
        sight.setOnClickListener(commonClickListener)
        right.setOnClickListener(commonClickListener)
        lie.setOnClickListener(commonClickListener)
        die.setOnClickListener(commonClickListener)
        pie.setOnClickListener(commonClickListener)

    }
}