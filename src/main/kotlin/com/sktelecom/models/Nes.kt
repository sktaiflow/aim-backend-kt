package com.sktelecom.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class NesJob(
    val id: Int,
    val userId: String,
    val jobId: String,
    val notebookUrl: String,
    val outputUrl: String,
    val runtimeName: String,
    val runtimeSpec: String,
    val runtimeImage: String,
    val runtimeTag: String,
    val parameters: String,
    val lastState: String
//    val createdAt: String
)

object NesJobs : Table("nes_job") {
    val id = integer("id")
    val userId = varchar("user_id", 255)
    val jobId = varchar("job_id", 255)
    val notebookUrl = varchar("notebook_url", 255)
    val outputUrl = varchar("output_url", 255)
    val runtimeName = varchar("runtime_name", 255)
    val runtimeSpec = varchar("runtime_spec", 255)
    val runtimeImage = varchar("runtime_image", 255)
    val runtimeTag = varchar("runtime_tag", 255)
    val parameters = varchar("parameters", 255)
    val lastState = varchar("last_state", 255)
//    val createdAt = varchar("created_at", 255)

    override val primaryKey = PrimaryKey(id)
}
