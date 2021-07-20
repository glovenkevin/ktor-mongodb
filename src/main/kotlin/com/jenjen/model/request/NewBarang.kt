package com.jenjen.model.request

data class NewBarang(
    val id : Int,
    val name : String,
    val desc : String = "",
    val code : String,
    val price : Double
)
