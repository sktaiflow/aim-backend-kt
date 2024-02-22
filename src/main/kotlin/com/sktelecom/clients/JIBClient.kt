package com.sktelecom.clients

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class BaseImage(
    val id: Int,
    val runtime: String,
    val name: String,
    @SerialName("latest_succeeded_tag") val latestSucceededTag: String,
    @SerialName("created_at") val createdAt: String,
)

class JIBClient {
    companion object JIBClient {
        private val client =
            HttpClient(CIO) {
                install(ContentNegotiation) {
                    json(Json { ignoreUnknownKeys = true })
                }
            }

        fun getBaseImages(): List<BaseImage> {
            return runBlocking {
                client.get("https://image-builder-dev.sktai.io/api/jupyter/base-images").body()
            }
        }
    }
}
