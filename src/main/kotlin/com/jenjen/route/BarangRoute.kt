package com.jenjen.route

import com.jenjen.model.request.NewBarang
import com.jenjen.services.IBarang
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Route.barangRoute() {

    val barangImpl by di().instance<IBarang>()

    route("/barang") {
        post("/insert") {
            val param = call.receive<NewBarang>()
            val rtn = barangImpl.insertBarang(param)
            call.respond(rtn)
        }
    }
}