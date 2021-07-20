package com.jenjen.entity

data class Barang(
    val id : Int,
    val name : String,
    val desc : String = "",
    val code : String,
    val price : Double
)
