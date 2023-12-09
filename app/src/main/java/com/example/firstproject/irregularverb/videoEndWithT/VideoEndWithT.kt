package com.example.firstproject.irregularverb.videoEndWithT

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class VideoEndWithT : AppCompatActivity() {

    private lateinit var recycler_view: RecyclerView
    private lateinit var list: ArrayList<VerbsModel>
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switch_btn: Switch
    private lateinit var count: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_end_with_t)

        val color = android.graphics.Color.parseColor("#009688")
        window.statusBarColor = color
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        switch_btn = findViewById(R.id.switch_btn)
        count = findViewById(R.id.count)

        switch_btn.setOnClickListener {
            MyApplication.lisnten = switch_btn.isChecked
        }

        recycler_view = findViewById(R.id.recycler_view)
        list = arrayListOf()
        list.add(VerbsModel(R.drawable.zoo, "Feel", 0, "Felt", R.raw.felt, "Feeling", R.raw.feeling,"I feel Happy.",R.raw.feel1,"She felt sedness.",R.raw.felt1,"He's feeling tired.",R.raw.feeling1, arrayListOf("i am feel Happy.")))
        list.add(VerbsModel(R.drawable.zoo, "Send", R.raw.send, "Sent", R.raw.sent, "Sending", R.raw.sending,"I will send the email.",R.raw.send1,"I sent the message.",R.raw.sent1,"She is sending message.",R.raw.sanding1,arrayListOf()))
        list.add(VerbsModel(R.drawable.zoo, "Spend", R.raw.spend, "Spent", R.raw.spent,"Spending",R.raw.spending,"He will spend the day at the park.",R.raw.spend1,"She spent her weekend reading books.",R.raw.spent1,"She is spending.",R.raw.spending1,arrayListOf("I spend.....")))

        count.text = "1/${list.size}"
        recycler_view.adapter = VideoEndWithTAdapter(this, list)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}