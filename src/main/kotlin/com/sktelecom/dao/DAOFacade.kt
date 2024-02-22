package com.sktelecom.dao

import com.sktelecom.models.NesJob
import com.sktelecom.models.User

interface DAOFacade {
    suspend fun users(): List<User>

    suspend fun nesJobs(): List<NesJob>
}
