package com.sktelecom.dao

import com.sktelecom.dao.Database.dbQuery
import com.sktelecom.models.User
import com.sktelecom.models.Users
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class UserDAOImpl : UserDAO {
    private fun resultRowToUser(row: ResultRow) =
        User(
            id = row[Users.id],
            name = row[Users.name]
        )

    override suspend fun users(): List<User> =
        dbQuery {
            Users.selectAll().map(::resultRowToUser)
        }
}

val userDao: UserDAO =
    UserDAOImpl().apply {
        runBlocking {
        }
    }
