package com.sktelecom.dao

import com.sktelecom.models.User

interface DAOFacade {
    suspend fun users(): List<User>
}
