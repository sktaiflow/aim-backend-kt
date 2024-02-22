package com.sktelecom.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class User(
    val id: String,
    val name: String,
    val `class`: String,
    val email: String,
    val uidNumber: Int
)

object Users : Table("sktml_user_info") {
    val id = varchar("userid", 255)
    val name = varchar("name", 255)
    val `class` = varchar("class", 255)
    val email = varchar("email", 255)
    val uidNumber = integer("uidnumber")

    override val primaryKey = PrimaryKey(id)
}
