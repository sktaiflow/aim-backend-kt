package com.sktelecom

import com.sktelecom.dao.DatabaseSingleton
import com.sktelecom.dao.dao
import com.sktelecom.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.log
import java.util.*
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseSingleton.init()
    configureRouting()

    Timer().scheduleAtFixedRate(0, 60 * 1000) {
        runBlocking {
            log.info(dao.nesJobs().size.toString())
        }
    }
}
