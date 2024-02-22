package com.sktelecom.dao

import com.sktelecom.models.Users
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object Database {
    fun init(
        url: String,
        driver: String,
        user: String,
        password: String
    ) {
        val database = Database.connect(url, driver, user, password)
        transaction(database) { SchemaUtils.create(Users) }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { block() }
}
