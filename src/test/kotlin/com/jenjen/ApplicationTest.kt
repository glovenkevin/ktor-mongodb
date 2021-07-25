package com.jenjen

import com.jenjen.plugins.configureRouting
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/healthCheck").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}