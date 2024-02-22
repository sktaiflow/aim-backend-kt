package com.sktelecom

import com.sktelecom.dao.DatabaseSingleton
import com.sktelecom.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

fun main() {
    Timer().scheduleAtFixedRate(0, 60 * 1000) {
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseSingleton.init()
    configureRouting()
}
