package com.example.firstproject.irregularverb.verbquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.MainActivity
import com.example.firstproject.R
import com.example.firstproject.irregularverb.videoEndWithT.Util.Companion.speak

class VerbQuiz : AppCompatActivity() {

    private val quiz_list = ArrayList<QuizModel>()
    private var totalQuiz: Int = 0
    private var qCounter: Int = 0
    private lateinit var currentQuiz: QuizModel
    private lateinit var opt_1: TextView
    private lateinit var opt_2: TextView
    private lateinit var opt_3: TextView
    private lateinit var quiz_counter: TextView
    private lateinit var quiz_image: ImageView
    private lateinit var right_dialog: RelativeLayout
    private lateinit var right_dialog_textview: TextView
    private lateinit var btnNext: ImageButton
    lateinit var progress_bar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb_quiz)
        val color = android.graphics.Color.parseColor("#CFC6C6")
        window.statusBarColor = color

        quiz_counter = findViewById(R.id.quiz_counter)
        quiz_image = findViewById(R.id.quiz_image)
        opt_1 = findViewById(R.id.opt_1)
        opt_2 = findViewById(R.id.opt_2)
        opt_3 = findViewById(R.id.opt_3)
        right_dialog = findViewById(R.id.right_dialog)
        right_dialog_textview = findViewById(R.id.right_dialog_textview)
        btnNext = findViewById(R.id.btnNext)
        progress_bar = findViewById(R.id.progress_bar)
        quiz_list.clear()

        quiz_list.add(QuizModel(0, "drink", "drunk", "drank", "drink"))
        quiz_list.add(QuizModel(0, "feel", "felt", "feeling", "felt"))

        totalQuiz = quiz_list.size

        shownextQuiz()

        opt_1.setOnClickListener {
            if (opt_1.text == currentQuiz.ans) {
                opt_1.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_green_light
                    )
                )
                right_dialog.visibility = View.VISIBLE
                right_dialog_textview.text =
                    "${currentQuiz.firstform} ${currentQuiz.secform} ${currentQuiz.thirdform}"
                opt_3.isEnabled = false
                opt_2.isEnabled = false
            } else {
                opt_1.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_red_dark
                    )
                )
                opt_3.isEnabled = false
                opt_2.isEnabled = false
            }
        }

        opt_2.setOnClickListener {
            if (opt_2.text == currentQuiz.ans) {
                opt_2.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_green_light
                    )
                )
                right_dialog.visibility = View.VISIBLE
                right_dialog_textview.text =
                    "${currentQuiz.firstform} ${currentQuiz.secform} ${currentQuiz.thirdform}"
                opt_1.isEnabled = false
                opt_3.isEnabled = false
            } else {
                opt_2.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_red_dark
                    )
                )
                opt_1.isEnabled = false
                opt_3.isEnabled = false
            }
        }

        opt_3.setOnClickListener {
            if (opt_3.text == currentQuiz.ans) {
                opt_3.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_green_light
                    )
                )
                right_dialog.visibility = View.VISIBLE
                right_dialog_textview.text =
                    "${currentQuiz.firstform} ${currentQuiz.secform} ${currentQuiz.thirdform}"
                opt_1.isEnabled = false
                opt_2.isEnabled = false
            } else {
                opt_3.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_red_dark
                    )
                )
                opt_1.isEnabled = false
                opt_2.isEnabled = false
            }
        }

        btnNext.setOnClickListener {
            shownextQuiz()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun shownextQuiz() {
        if (qCounter < totalQuiz) {
            currentQuiz = quiz_list[qCounter]
            opt_1.text = currentQuiz.firstform
            opt_2.text = currentQuiz.secform
            opt_3.text = currentQuiz.thirdform
            qCounter++
            quiz_counter.text = "${qCounter}/${totalQuiz}"

            opt_1.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
            opt_2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
            opt_3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
            right_dialog.visibility = View.INVISIBLE

            opt_1.isEnabled = true
            opt_2.isEnabled = true
            opt_3.isEnabled = true

            speak(this, currentQuiz.firstform, currentQuiz.image)

            updateProgressBar()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun updateProgressBar() {

        val progressValue = (qCounter.toFloat() / totalQuiz.toFloat() * 100).toInt()
        progress_bar.progress = progressValue

    }

}