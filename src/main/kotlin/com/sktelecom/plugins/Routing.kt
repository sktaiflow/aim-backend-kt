package com.sktelecom.plugins

import com.sktelecom.clients.BaseImage
import com.sktelecom.clients.JIBClient
import com.sktelecom.dao.dao
import com.sktelecom.models.User
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AIMResponse(
    @SerialName("base_images") val baseImages: List<BaseImage>,
    val users: List<User>
)

fun Application.configureRouting() {
    routing {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
        get("/") {
            call.respond(AIMResponse(JIBClient.getBaseImages(), dao.users()))
        }
    }
}
