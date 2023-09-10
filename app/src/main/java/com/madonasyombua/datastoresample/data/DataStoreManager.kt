package com.madonasyombua.datastoresample.data

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun saveTasks(tasks: Tasks)
    fun getTasks(): Flow<Tasks>
    suspend fun saveTasksToProtoStore(tasks: Tasks)
    fun getTasksFromProtoStore(): Flow<Tasks>
}