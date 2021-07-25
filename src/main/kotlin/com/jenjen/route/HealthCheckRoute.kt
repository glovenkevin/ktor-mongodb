package com.jenjen.route

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.healthCheck() {
    route("/healthCheck") {
        get {
            call.respond(HttpStatusCode.OK)
        }
    }
}