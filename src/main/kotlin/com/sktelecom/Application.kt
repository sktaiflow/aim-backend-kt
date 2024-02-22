package com.sktelecom

import com.sktelecom.dao.DatabaseSingleton
import com.sktelecom.plugins.configureRouting
import io.ktor.server.application.Application
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseSingleton.init()
    configureRouting()

    Timer().scheduleAtFixedRate(0, 60 * 1000) {
    }
}
