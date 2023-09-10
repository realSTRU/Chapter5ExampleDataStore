package com.madonasyombua.datastoresample.mediator

import com.madonasyombua.datastoresample.data.DataStoreManager
import com.madonasyombua.datastoresample.data.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServiceImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : TaskService {
    override fun getTasksFromPrefDataStore() = dataStoreManager.getTasks()

    override suspend fun addTasks(tasks: Tasks) {
        dataStoreManager.saveTasks(tasks)
        dataStoreManager.saveTasksToProtoStore(tasks)
    }

    override fun getTasks(): Flow<Tasks> = getTasksFromProtoDataStore()

    override fun getTasksFromProtoDataStore(): Flow<Tasks> =
        dataStoreManager.getTasksFromProtoStore()
}