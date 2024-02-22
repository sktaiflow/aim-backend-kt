package com.sktelecom

import com.sktelecom.dao.DatabaseSingleton
import com.sktelecom.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseSingleton.init()
    configureRouting()

    Timer().scheduleAtFixedRate(0, 60 * 1000) {
    }

    val port = environment.config.propertyOrNull("ktor.deployment.port")?.getString() ?: "8080"
    println("AA $port BB")
    routing {
        get {
            call.respondText("Listening on port $port")
        }
    }
}
