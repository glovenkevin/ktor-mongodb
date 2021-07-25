package com.jenjen.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

data class Barang(
    @BsonId
    val _id : Int,
    val name : String,
    val desc : String = "",
    val code : String,
    val price : Double,
    val tipe : JenisBarang
)
