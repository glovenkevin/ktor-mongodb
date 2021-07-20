package com.jenjen

import com.jenjen.plugins.*
import io.ktor.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
    configureHTTP()
    configureMonitoring()
    configureCompression()
    configureDI()
}
