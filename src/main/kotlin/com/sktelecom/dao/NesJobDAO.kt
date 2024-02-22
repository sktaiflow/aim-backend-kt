package com.sktelecom.dao

import com.sktelecom.models.NesJob
import com.sktelecom.models.NesJobs
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select

interface NesJobDAO {
    suspend fun nesJobs(): List<NesJob>
}

class NesJobDAOImpl : NesJobDAO {
    private fun resultRowToNesJob(row: ResultRow) =
        NesJob(
            id = row[NesJobs.id],
            userId = row[NesJobs.userId],
            jobId = row[NesJobs.jobId],
            notebookUrl = row[NesJobs.notebookUrl],
            outputUrl = row[NesJobs.outputUrl],
            runtimeName = row[NesJobs.runtimeName],
            runtimeSpec = row[NesJobs.runtimeSpec],
            runtimeImage = row[NesJobs.runtimeImage],
            runtimeTag = row[NesJobs.runtimeTag],
            parameters = row[NesJobs.parameters],
            lastState = row[NesJobs.lastState]
//            createdAt = row[NesJobs.createdAt]
        )

    override suspend fun nesJobs(): List<NesJob> =
        Database.dbQuery {
            NesJobs.select { NesJobs.userId eq "1112369" }.map(::resultRowToNesJob)
        }
}

val nesJobDao: NesJobDAO =
    NesJobDAOImpl().apply {
        runBlocking {
        }
    }
