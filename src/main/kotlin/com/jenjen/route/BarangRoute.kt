package com.jenjen.route

import com.jenjen.model.request.BarangGreaterAndLessPrice
import com.jenjen.model.request.NewBarang
import com.jenjen.model.request.NewBarangMass
import com.jenjen.model.response.DefaultResponse
import com.jenjen.services.IBarang
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Route.barangRoute() {

    val barangImpl by di().instance<IBarang>()

    route("barang") {

        get {
            return@get call.respond(
                barangImpl.getListBarang()
            )
        }

        get("{id}") {
            val param = call.parameters["id"] ?: return@get call.respond(
                DefaultResponse(400, "Bad Request")
            )
            call.respond(barangImpl.getBarang(param.toInt()))
        }

        get("tipe/{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(
                DefaultResponse(400, "Bad Request")
            )
            return@get call.respond(
                barangImpl.getListBarangByTipe(id.toInt())
            )
        }

        get("greaterThen/{price}") {
            val id = call.parameters["price"] ?: return@get call.respond(
                DefaultResponse(400, "Bad Request")
            )
            return@get call.respond(
                barangImpl.getListBarangPriceGreaterThen(id.toDouble())
            )
        }

        post("greaterThenAndLessThen") {
            val param = call.receive<BarangGreaterAndLessPrice>()
            return@post call.respond(barangImpl.getListGreaterAndLessThen(param))
        }

        get("lessThen/{price}") {
            val id = call.parameters["price"] ?: return@get call.respond(
                DefaultResponse(400, "Bad Request")
            )
            return@get call.respond(
                barangImpl.getListBarangPriceLessThen(id.toDouble())
            )
        }

        post("insert") {
            val param = call.receive<NewBarang>()
            val rtn = barangImpl.insertBarang(param)
            call.respond(rtn)
        }

        post("insertMass") {
            val listParam = call.receive<NewBarangMass>()
            call.respond(barangImpl.insertMassBarang(listParam))
        }

        delete("{id}") {
            val param = call.parameters["id"] ?: return@delete call.respond(
                DefaultResponse(400, "Bad Request")
            )
            call.respond(barangImpl.deleteBarang(param.toInt()))
        }

    }
}