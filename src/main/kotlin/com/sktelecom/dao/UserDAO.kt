package com.sktelecom.dao

import com.sktelecom.models.User

interface UserDAO {
    suspend fun users(): List<User>
}
