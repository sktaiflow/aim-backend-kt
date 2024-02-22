package com.sktelecom.dao

import com.sktelecom.dao.DatabaseSingleton.dbQuery
import com.sktelecom.models.User
import com.sktelecom.models.Users
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToUser(row: ResultRow) =
        User(
            id = row[Users.id],
            name = row[Users.name],
        )

    override suspend fun users(): List<User> =
        dbQuery {
            Users.selectAll().map(::resultRowToUser)
        }
}

val dao: DAOFacade =
    DAOFacadeImpl().apply {
        runBlocking {
        }
    }
