package com.example.firstproject.irregularverb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class IrregularVerb : AppCompatActivity() {

    lateinit var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_verb)

        recycler_view = findViewById(R.id.recycler_view)

        val list = mutableListOf<IrregularModel>()

        list.add(IrregularModel("beat","beated","beating",false))
        list.add(IrregularModel("bend","bended","bending",false))
        list.add(IrregularModel("bite","biteed","biteing",false))

        recycler_view.adapter = IrregularAdapter(this,list)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}