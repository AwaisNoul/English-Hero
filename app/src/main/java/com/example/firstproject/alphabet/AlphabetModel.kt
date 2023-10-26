package com.example.firstproject.alphabet

data class AlphabetModel(

    val letter: String = "",
    var word: String = "",
    var img: Int = 0,
    var flip: Boolean,
    var audioLetter: Int = 0,
    var audioWord: Int = 0

)