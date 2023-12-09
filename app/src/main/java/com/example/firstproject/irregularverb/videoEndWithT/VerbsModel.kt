package com.example.firstproject.irregularverb.videoEndWithT

data class VerbsModel(
    val image: Int = 0,
    val firstform: String = "",
    val firstformaudio: Int = 0,
    val secform: String = "",
    val secformaudio: Int = 0,
    val thirdform: String = "",
    val thirdformaudio: Int = 0,
    val sentrnce1form: String = "",
    val sentrnce1formaudio: Int = 0,
    val sentrnce2form: String = "",
    val sentrnce2formaudio: Int = 0,
    val sentrnce3form: String = "",
    val sentrnce3formaudio: Int = 0,
    val usesList : ArrayList<String> = arrayListOf("")
)