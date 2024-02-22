package com.sktelecom

import com.sktelecom.dao.Database
import com.sktelecom.dao.nesJobDao
import com.sktelecom.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.log
import java.util.*
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    Database.init(
        environment.config.property("database.url").getString(),
        environment.config.property("database.driver").getString(),
        environment.config.property("database.user").getString(),
        environment.config.property("database.password").getString()
    )
    configureRouting()

    Timer().scheduleAtFixedRate(0, 60 * 1000) {
        runBlocking {
            log.info(nesJobDao.nesJobs().size.toString())
        }
    }
}
