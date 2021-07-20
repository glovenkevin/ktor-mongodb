package com.jenjen.plugins

import com.jenjen.config.bindMongoServices
import com.jenjen.config.bindServices
import io.ktor.application.*
import org.kodein.di.ktor.di

fun Application.configureDI() {
    di {
        bindMongoServices()
        bindServices()
    }
}
