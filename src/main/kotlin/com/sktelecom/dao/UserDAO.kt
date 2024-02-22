package com.sktelecom.dao

import com.sktelecom.models.User
import com.sktelecom.models.Users
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

interface UserDAO {
    suspend fun users(): List<User>
}

class UserDAOImpl : UserDAO {
    private fun resultRowToUser(row: ResultRow) =
        User(
            id = row[Users.id],
            name = row[Users.name]
        )

    override suspend fun users(): List<User> =
        Database.dbQuery {
            Users.selectAll().map(::resultRowToUser)
        }
}

val userDao: UserDAO =
    UserDAOImpl().apply {
        runBlocking {
        }
    }
