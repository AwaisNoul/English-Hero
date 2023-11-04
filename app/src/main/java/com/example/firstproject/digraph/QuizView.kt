package com.example.firstproject.digraph

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstproject.MainActivity
import com.example.firstproject.R
import com.nex3z.flowlayout.FlowLayout

class QuizView : AppCompatActivity() {

    private val question_list = ArrayList<SentenceModel>()
    private var words = arrayOf<String>()
    private var tQuestions = 0
    private var qCounter = 0
    private lateinit var currentQuestion: SentenceModel
    private lateinit var question_counter: TextView
    private var wrong = 0
    private var right = 0
    private lateinit var question_tv: TextView
    private lateinit var question_image: ImageView
    private lateinit var flow: FlowLayout
    private lateinit var answer_textview: TextView
    private lateinit var checkButton: TextView
    private lateinit var right_question_textview: TextView
    private lateinit var wrong_question_textview: TextView
    private lateinit var card: RelativeLayout
    private lateinit var answer_image: ImageView
    private lateinit var check: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_view)
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusbarcolor1)

        question_counter = findViewById(R.id.question_counter)
        question_tv = findViewById(R.id.question_tv)
        question_image = findViewById(R.id.question_image)
        answer_textview = findViewById(R.id.answer_textview)
        checkButton = findViewById(R.id.checkButton)
        flow = findViewById(R.id.flow)
        right_question_textview = findViewById(R.id.right_question_textview)
        wrong_question_textview = findViewById(R.id.wrong_question_textview)
        card = findViewById(R.id.card)
        answer_image = findViewById(R.id.button_cardview_img)
        check = findViewById(R.id.check)

        question_list.clear()
        words = arrayOf()

        question_list.add(SentenceModel("cat", "بلی", R.raw.cat, R.drawable.cat, "c,d,e,t,f,a"))
        question_list.add(
            SentenceModel(
                "Dady",
                "باپ",
                R.raw.dady,
                R.drawable.dady,
                "c,D,e,d,y,f,a"
            )
        )

        tQuestions = question_list.size

        showNextQuestion()

        var i = 0
        checkButton.setOnClickListener {
            i++
            val originalString = answer_textview.text.toString()
            val stringWithoutSpaces = originalString.replace(" ", "")

            if (i == 1) {
                if (stringWithoutSpaces == currentQuestion.ans) {
                    right++
                    right_question_textview.text = right.toString()
                    card.visibility = View.VISIBLE
                    card.startAnimation(AnimationUtils.loadAnimation(this, R.anim.come_from_bottom))
                    card.setBackgroundResource(R.drawable.correct_background)
                    answer_image.setImageResource(R.drawable.right_img)
                    checkButton.text = "Next"
                    check.text = "ممتاز!"
                    val mediaPlayer = MediaPlayer.create(this, R.raw.right_answer)
                    mediaPlayer.start()
                } else {
                    wrong++
                    wrong_question_textview.text = wrong.toString()
                    card.visibility = View.VISIBLE
                    card.startAnimation(AnimationUtils.loadAnimation(this, R.anim.come_from_bottom))
                    card.setBackgroundResource(R.drawable.wrong_background)
                    answer_image.setImageResource(R.drawable.wrong_img)
                    checkButton.text = "Next"
                    check.text = currentQuestion.ans
                    val mediaPlayer = MediaPlayer.create(this, R.raw.wrong_answer)
                    mediaPlayer.start()
                }
            } else {
                showNextQuestion()
                i = 0
            }
        }
    }

    private fun showNextQuestion() {
        if (qCounter < tQuestions) {
            card.visibility = View.GONE
            flow.removeAllViews()

            currentQuestion = question_list[qCounter]
            answer_textview.text = ""
            question_tv.text = currentQuestion.title

            val text = currentQuestion.word1

            question_image.setImageResource(currentQuestion.image)
            val audioResourceId = currentQuestion.audio
            val mediaPlayer = MediaPlayer.create(this, audioResourceId)
            question_image.setOnClickListener {
                mediaPlayer.start()
            }

            words = text.split(",").toTypedArray()

            setTextInFlow(words)

            question_counter.text = "Question: ${qCounter + 1}/${question_list.size}"
            qCounter++

            for (i in 0 until flow.childCount) {
                val textView = flow.getChildAt(i) as TextView
                var isSelected = false
                textView.setOnClickListener {
                    // Reset the state for the new question

                    var currentAnswer = answer_textview.text.toString()

                    // When a TextView is clicked, set its text to the answer_textview
                    val clickedWord = textView.text.toString()

                    if (currentAnswer.isEmpty()) {
                        answer_textview.text = clickedWord
                    } else {
                        answer_textview.text = "$currentAnswer $clickedWord"
                    }

                    // Toggle the background color
                    if (isSelected) {
                        // If it's selected, remove the item from the answer
                        currentAnswer = currentAnswer.replace(clickedWord, "").trim()
                        textView.setBackgroundResource(R.drawable.tv_background)
                    } else {
                        // If it's not selected, add the item to the answer
                        currentAnswer = "$currentAnswer $clickedWord".trim()
                        textView.setBackgroundResource(R.drawable.pressed_btn_background)
                    }

                    answer_textview.text = currentAnswer
                    isSelected = !isSelected // Toggle the item's state
                }
            }
        } else {
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, 1000)
        }
    }

    private fun setTextInFlow(words: Array<String>) {
        for (i in words.indices) {
            val textView = TextView(this)
            textView.text = getWordAtIndex(i).trim()
            textView.textSize = 20f
            textView.setBackgroundResource(R.drawable.tv_background)
            textView.minWidth = 170
            textView.gravity = Gravity.CENTER_HORIZONTAL
            visi(textView)
            textView.setPadding(20, 10, 20, 15)
            flow.setBackgroundResource(R.drawable.flow_background)
            flow.setPadding(16, 25, 16, 25)
            textView.setTextColor(resources.getColor(R.color.default_text_color))
            flow.addView(textView)
        }
    }

    private fun visi(textView: TextView) {
        if (textView.text.toString().isEmpty()) {
            textView.visibility = View.GONE
        } else {
            textView.visibility = View.VISIBLE
        }
    }

    private fun getWordAtIndex(index: Int): String {
        return if (index >= 0 && index < words.size) {
            words[index]
        } else {
            ""
        }
    }
}