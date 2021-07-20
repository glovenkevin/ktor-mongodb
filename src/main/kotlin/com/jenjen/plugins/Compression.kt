package com.jenjen.plugins

import io.ktor.application.*
import io.ktor.features.*

fun Application.configureCompression() {
    install(Compression) {
        gzip()
        deflate()
    }
}