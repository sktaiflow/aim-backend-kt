package com.sktelecom.dao

import com.sktelecom.dao.DatabaseSingleton.dbQuery
import com.sktelecom.models.NesJob
import com.sktelecom.models.NesJobs
import com.sktelecom.models.User
import com.sktelecom.models.Users
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToUser(row: ResultRow) =
        User(
            id = row[Users.id],
            name = row[Users.name]
        )

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

    override suspend fun users(): List<User> =
        dbQuery {
            Users.selectAll().map(::resultRowToUser)
        }

    override suspend fun nesJobs(): List<NesJob> =
        dbQuery {
            NesJobs.select { NesJobs.userId eq "1112369" }.map(::resultRowToNesJob)
        }
}

val dao: DAOFacade =
    DAOFacadeImpl().apply {
        runBlocking {
        }
    }
