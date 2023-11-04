package com.example.firstproject.irregularverb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class IrregularListActivity : AppCompatActivity() {

    private lateinit var recycler_view : RecyclerView
    private lateinit var list: ArrayList<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_list)
        window.statusBarColor = ContextCompat.getColor(this,R.color.statusbarcolor1)

        recycler_view = findViewById(R.id.recycler_view)
        list = arrayListOf()

        list.add("hello")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")
        list.add("World")

        recycler_view.adapter = IrregularListAdapter(this,list)
        recycler_view.layoutManager = LinearLayoutManager(this)



    }
}