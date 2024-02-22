package com.sktelecom.plugins

import com.sktelecom.clients.JIBClient
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    routing {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                },
            )
        }
        get("/") {
            call.respond(JIBClient.getBaseImages())
//            call.respond(dao.users())
        }
    }
}
