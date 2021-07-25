package com.jenjen.model.request

import com.jenjen.entity.JenisBarang

data class NewBarang(
    val id : Int,
    val name : String,
    val desc : String = "",
    val code : String,
    val price : Double,
    val tipe : JenisBarang
)
