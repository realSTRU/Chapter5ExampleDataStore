package com.madonasyombua.datastoresample.mediator

import com.madonasyombua.datastoresample.data.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskService {
    fun getTasksFromPrefDataStore() : Flow<Tasks>
    suspend fun addTasks(tasks: Tasks)
    fun getTasks(): Flow<Tasks>
    fun getTasksFromProtoDataStore(): Flow<Tasks>
}