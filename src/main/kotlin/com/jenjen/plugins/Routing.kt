package com.jenjen.plugins

import com.jenjen.route.barangRoute
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        route("/v1") {
            barangRoute()
        }
    }
}
