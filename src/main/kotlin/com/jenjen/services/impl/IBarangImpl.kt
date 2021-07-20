package com.jenjen.services.impl

import com.jenjen.entity.Barang
import com.jenjen.model.request.NewBarang
import com.jenjen.model.response.DefaultResponse
import com.jenjen.services.IBarang
import org.litote.kmongo.coroutine.CoroutineClient

class BarangImpl(
    private val mongoClient: CoroutineClient
) : IBarang {

    override suspend fun insertBarang(newBarang : NewBarang): DefaultResponse {
        val barang = Barang(
            id = newBarang.id,
            name = newBarang.name,
            desc = newBarang.desc,
            code = newBarang.code,
            price = newBarang.price
        )
        mongoClient.getDatabase("test")
            .getCollection<Barang>("barangs")
            .insertOne(barang)
        return DefaultResponse(200, "success")
    }

}