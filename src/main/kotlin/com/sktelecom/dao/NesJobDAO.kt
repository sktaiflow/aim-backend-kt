package com.sktelecom.dao

import com.sktelecom.models.NesJob

interface NesJobDAO {
    suspend fun nesJobs(): List<NesJob>
}
