package com.example.firstproject.alphabet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R

class Alphabet_rec : AppCompatActivity() {

    lateinit var recycler_view : RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_rec)
        recycler_view = findViewById(R.id.recycler_view)

        val list = mutableListOf<AlphabetModel>()
        list.add(AlphabetModel("A a" , "Ant" , R.drawable.ant , false , R.raw.a1 , R.raw.ant))
        list.add(AlphabetModel("B b" , "Baby" , R.drawable.baby , false , R.raw.b1 , R.raw.baby))
        list.add(AlphabetModel("C c" , "Cat" , R.drawable.cat , false , R.raw.c1 , R.raw.cat))
        list.add(AlphabetModel("D d" , "Dady" , R.drawable.dady , false , R.raw.d1 , R.raw.dady))
        list.add(AlphabetModel("E e" , "Elephant" , R.drawable.elephant , false , R.raw.e1 , R.raw.elephant))
        list.add(AlphabetModel("F f" , "Family" , R.drawable.family , false , R.raw.f1 , R.raw.family))
        list.add(AlphabetModel("G g" , "Game" , R.drawable.console , false , R.raw.g1 , R.raw.g1))
        list.add(AlphabetModel("H h" , "Hand" , R.drawable.hand , false , R.raw.h1 , R.raw.hand))
        list.add(AlphabetModel("I i" , "Ink" , R.drawable.ink , false , R.raw.i1 , R.raw.ink))
        list.add(AlphabetModel("J j" , "Jam" , R.drawable.jam , false , R.raw.j1 , R.raw.jam))
        list.add(AlphabetModel("K k" , "King" , R.drawable.king , false , R.raw.k1 , R.raw.king))
        list.add(AlphabetModel("L l" , "Lamp" , R.drawable.lamp , false , R.raw.l1 , R.raw.lamp))
        list.add(AlphabetModel("M m" , "Man" , R.drawable.man , false , R.raw.m1 , R.raw.man))
        list.add(AlphabetModel("N n" , "Noes" , R.drawable.nose , false , R.raw.n1 , R.raw.noes))
        list.add(AlphabetModel("O o" , "Olives" , R.drawable.olives , false , R.raw.o1 , R.raw.olive))
        list.add(AlphabetModel("P p" , "Park" , R.drawable.park , false , R.raw.p1, R.raw.park))
        list.add(AlphabetModel("Q q" , "Queen" , R.drawable.queen , false , R.raw.q1, R.raw.queen))
        list.add(AlphabetModel("R r" , "Rabbit" , R.drawable.rabbit , false , R.raw.r1, R.raw.rabbit))
        list.add(AlphabetModel("S s" , "Sun" , R.drawable.sun , false , R.raw.s1, R.raw.sun))
        list.add(AlphabetModel("T t" , "Tree" , R.drawable.tree , false , R.raw.t1, R.raw.tree))
        list.add(AlphabetModel("U u" , "Up" , R.drawable.up , false , R.raw.u1, R.raw.u1))
        list.add(AlphabetModel("V v" , "Van" , R.drawable.van , false , R.raw.v1, R.raw.van))
        list.add(AlphabetModel("W w" , "Wind" , R.drawable.wind , false , R.raw.w1, R.raw.wind))
        list.add(AlphabetModel("X x" , "X-ray" , R.drawable.xray , false , R.raw.x1, R.raw.x1))
        list.add(AlphabetModel("Y y" , "Yellow" , R.drawable.yellow , false , R.raw.y1, R.raw.yellow))
        list.add(AlphabetModel("Z z" , "Zoo" , R.drawable.zoo , false , R.raw.z1, R.raw.zoo))

        recycler_view.adapter = Alphabet_Adapter(this,list)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}