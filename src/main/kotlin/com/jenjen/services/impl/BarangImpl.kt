package com.jenjen.services.impl

import com.jenjen.entity.Barang
import com.jenjen.entity.JenisBarang
import com.jenjen.model.request.BarangGreaterAndLessPrice
import com.jenjen.model.request.NewBarang
import com.jenjen.model.request.NewBarangMass
import com.jenjen.model.response.DefaultResponse
import com.jenjen.services.IBarang
import org.litote.kmongo.and
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.eq
import org.litote.kmongo.gt
import org.litote.kmongo.lt

class BarangImpl(
    mongoClient: CoroutineClient
) : IBarang {

    private val database = "test"
    private val collectionName = "barangs"
    private val collection = mongoClient.getDatabase(database).getCollection<Barang>(collectionName)

    override suspend fun insertBarang(newBarang : NewBarang): DefaultResponse {
        val barang = Barang(
            _id = newBarang.id,
            name = newBarang.name,
            desc = newBarang.desc,
            code = newBarang.code,
            price = newBarang.price,
            tipe = JenisBarang(
                id = newBarang.tipe.id,
                code = newBarang.tipe.code,
                desc = newBarang.tipe.desc
            )
        )
        collection.insertOne(barang)
        return DefaultResponse(200, "ok")
    }

    override suspend fun insertMassBarang(massNewBarang: NewBarangMass): DefaultResponse {
        val param = mutableListOf<Barang>()
        massNewBarang.data.forEach {
            param.add(
                Barang(
                    _id = it.id,
                    name = it.name,
                    desc = it.desc,
                    code = it.code,
                    price = it.price,
                    tipe = JenisBarang(
                        id = it.tipe.id,
                        code = it.tipe.code,
                        desc = it.tipe.desc
                    )
            ))
        }
        val result = collection.insertMany(param)
        val rtn = DefaultResponse(200, "ok")
        if (result.wasAcknowledged()) {
            rtn.data = "Data berhasil di insert"
        } else {
            rtn.data = "Data gagal di insert"
        }
        return rtn
    }

    override suspend fun getBarang(id: Int): DefaultResponse {
        val barang = collection.findOne(Barang::_id eq id)
        return DefaultResponse(200, "ok", barang)
    }

    override suspend fun getListBarang(): DefaultResponse {
        val listBarang = collection.find().toList()
        return DefaultResponse(200, "ok", listBarang)
    }

    override suspend fun getListBarangByTipe(id: Int): DefaultResponse {
        val listBarang = collection.find("{'tipe.id': $id}").toList()
        return DefaultResponse(200, "ok", listBarang)
    }

    override suspend fun getListBarangPriceGreaterThen(price: Double): DefaultResponse {
        val listBarang = collection.find(Barang::price gt price).toList()
        return DefaultResponse(200, "ok", listBarang)
    }

    override suspend fun getListBarangPriceLessThen(price: Double): DefaultResponse {
        val listBarang = collection.find(Barang::price lt price).toList()
        return DefaultResponse(200, "ok", listBarang)
    }

    override suspend fun getListGreaterAndLessThen(param: BarangGreaterAndLessPrice): DefaultResponse {
        val listBarang = collection.find(and(
            filters = listOf(
                Barang::price gt param.greaterThan,
                Barang::price lt param.lessThen
            )
        )).toList()
        return DefaultResponse(200, "ok", listBarang)
    }

    override suspend fun deleteBarang(id : Int): DefaultResponse {
        val res = collection.deleteOne(Barang::_id eq id)
        val rtn = DefaultResponse(200, "ok")
        if (res.deletedCount > 0) {
            rtn.data = "1 data terhapus"
        } else {
            rtn.data = "Tidak ada data terhapus"
        }
        return rtn
    }

}