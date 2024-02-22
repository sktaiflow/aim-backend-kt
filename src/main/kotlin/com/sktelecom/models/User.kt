package com.sktelecom.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class User(val id: String, val name: String)

object Users : Table("sktml_user_info") {
    val id = varchar("userid", 255)
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
