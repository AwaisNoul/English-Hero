package com.example.firstproject.alphabet

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.firstproject.MainActivity
import com.example.firstproject.R

class SpellingLetter : AppCompatActivity() {

    private lateinit var text_wrong_answer: TextView
    private lateinit var text_right_answer: TextView
    private lateinit var tvQuestionNo: TextView
    private lateinit var wron_answer: TextView
    private lateinit var btnNext: ImageButton
    private lateinit var speakerImageView: ImageView
    private lateinit var main_textview: TextView
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var speak: CardView
    private lateinit var radioGroup: RadioGroup
    private var qCounter: Int = 0
    private var tQuestions: Int = 0
    private lateinit var questionList: MutableList<SpellingModel>
    private lateinit var currentQuestion: SpellingModel
    private var answered = false
    private var right_answer: Int = 0
    private var wrong_answer: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spelling_letter)

        text_wrong_answer = findViewById(R.id.text_wrong_answer)
        text_right_answer = findViewById(R.id.text_right_answer)
        tvQuestionNo = findViewById(R.id.tvQuestionNo)
        main_textview = findViewById(R.id.main_textview)
        speak = findViewById(R.id.speak)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        radioGroup = findViewById(R.id.radioGroup)

        btnNext = findViewById(R.id.btnNext)
        wron_answer = findViewById(R.id.text_wrong_answer)
        questionList = mutableListOf()

        questionList.add(SpellingModel(R.raw.can, "Can", "Cane", "cone", "Can"))
        questionList.add(SpellingModel(R.raw.plan, "Plane", "Plan", "Plyn", "Plan"))
        questionList.add(SpellingModel(R.raw.name, "nme", "nam", "Name", "Name"))
        questionList.add(SpellingModel(R.raw.tap, "Tap", "Tape", "Top", "Tap"))

        tQuestions = questionList.size
        showNextQuestion()

        var i = 0
        btnNext.setOnClickListener {
            i++
            if (qCounter <= tQuestions) {
                radioButBackgrounds()
                if (!answered) {
                    if (rb1.isChecked || rb2.isChecked || rb3.isChecked) {
                        checkAnswer()
                    } else {
                        Toast.makeText(
                            this@SpellingLetter,
                            "Please, select an option",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    if (i > 0) {
                        showNextQuestion()
                    }
                }
            }
        }
    }

    private fun checkAnswer() {
        if (qCounter <= tQuestions) {
            val mediaPlayer_right = MediaPlayer.create(applicationContext, R.raw.right_answer)
            val mediaPlayer_wrong = MediaPlayer.create(applicationContext, R.raw.wrong_answer)
            val rbSelected = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val selectedAnswer = rbSelected.text.toString()

            if (selectedAnswer == currentQuestion.ans) {
                rbSelected.setBackgroundResource(R.drawable.right_btn_backround)
                right_answer++
                text_right_answer.text = right_answer.toString()
                btnNext.setImageResource(R.drawable.right_arrow)
                mediaPlayer_right.start()
            } else {
                rbSelected.setBackgroundResource(R.drawable.wrong_btn_backround)
                wrong_answer++
                text_wrong_answer.text = wrong_answer.toString()
                btnNext.setImageResource(R.drawable.right_arrow)
                mediaPlayer_wrong.start()

                if (currentQuestion.ans == rb1.text) {
                    rb1.setBackgroundResource(R.drawable.right_btn_backround)
                } else if (currentQuestion.ans == rb2.text) {
                    rb2.setBackgroundResource(R.drawable.right_btn_backround)
                } else if (currentQuestion.ans == rb3.text) {
                    rb3.setBackgroundResource(R.drawable.right_btn_backround)
                }
            }

//            rb1.isEnabled = false
//            rb2.isEnabled = false
//            rb3.isEnabled = false

            answered = true
        } else {
            // Handle quiz completion
        }
    }

    private fun showNextQuestion() {
        if (qCounter < tQuestions) {
            currentQuestion = questionList[qCounter]
            val audioResourceId = currentQuestion.question

            speak = findViewById(R.id.speak)
            val mediaPlayer = MediaPlayer.create(this, audioResourceId)
            speak.setOnClickListener {
                mediaPlayer.start()
            }
            mediaPlayer.start()
            btnNext.setImageResource(R.drawable.right)

            rb1.text = currentQuestion.op1
            rb2.text = currentQuestion.op2
            rb3.text = currentQuestion.op3
            rb1.setBackgroundResource(R.drawable.radio_onpressed_background)
            rb2.setBackgroundResource(R.drawable.radio_onpressed_background)
            rb3.setBackgroundResource(R.drawable.radio_onpressed_background)

            radioGroup.clearCheck()

            qCounter++
            tvQuestionNo.text = "Question: $qCounter/$tQuestions"
            answered = false
        } else {
            btnNext.setImageResource(R.drawable.finish)
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, 1000)
        }
    }

    private fun radioButBackgrounds() {
        btnNext.setImageResource(R.drawable.ic_baseline_check_24)
        rb1.setBackgroundResource(R.drawable.radio_background)
        rb1.setBackgroundResource(R.drawable.radio_onpressed_background)
        rb2.setBackgroundResource(R.drawable.radio_background)
        rb2.setBackgroundResource(R.drawable.radio_onpressed_background)
        rb3.setBackgroundResource(R.drawable.radio_background)
        rb3.setBackgroundResource(R.drawable.radio_onpressed_background)
    }
}