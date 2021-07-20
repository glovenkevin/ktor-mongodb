package com.jenjen.config

import com.jenjen.services.IBarang
import com.jenjen.services.impl.BarangImpl
import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun DI.MainBuilder.bindMongoServices() {
    val hoconFile = HoconApplicationConfig(ConfigFactory.load())
    val mongoURL = hoconFile.property("mongo.client").getString()
    bind<CoroutineClient>("mongoClient") with singleton { KMongo.createClient(mongoURL).coroutine }
}

fun DI.MainBuilder.bindServices() {
    bind<IBarang>() with singleton { BarangImpl(instance("mongoClient")) }
}
