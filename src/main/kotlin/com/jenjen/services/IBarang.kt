package com.jenjen.services

import com.jenjen.model.request.BarangGreaterAndLessPrice
import com.jenjen.model.request.NewBarang
import com.jenjen.model.request.NewBarangMass
import com.jenjen.model.response.DefaultResponse

interface IBarang {
    suspend fun insertBarang(newBarang : NewBarang): DefaultResponse
    suspend fun insertMassBarang(massNewBarang: NewBarangMass): DefaultResponse
    suspend fun getBarang(id : Int): DefaultResponse
    suspend fun getListBarang() : DefaultResponse
    suspend fun getListBarangByTipe(id : Int) : DefaultResponse
    suspend fun getListBarangPriceGreaterThen(price: Double): DefaultResponse
    suspend fun getListBarangPriceLessThen(price: Double): DefaultResponse
    suspend fun getListGreaterAndLessThen(param: BarangGreaterAndLessPrice): DefaultResponse
    suspend fun deleteBarang(id : Int) : DefaultResponse
}