package com.madonasyombua.datastoresample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.datastoresample.data.TaskDataSource
import com.madonasyombua.datastoresample.data.Tasks
import com.madonasyombua.datastoresample.mediator.TaskService
import com.madonasyombua.datastoresample.util.asLiveDataOnDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskService: TaskService
) : ViewModel() {

    private var saveFinish: (() -> Unit)? = null

    fun saveTaskData(tasks: Tasks) {
        viewModelScope.launch {
         //   Log.d("Task", "asdf Data was inserted correctly")
            taskService.addTasks(tasks)
            saveFinish?.invoke()
        }
    }

    val taskList: LiveData<List<Pair<TaskDataSource, Tasks>>> = combine(
        taskService.getTasksFromPrefDataStore(),
        taskService.getTasksFromProtoDataStore()
    ) { prefDataStore, protoDataStore ->
        listOf(
            TaskDataSource.PREFERENCES_DATA_STORE to prefDataStore,
            TaskDataSource.PROTO_DATA_STORE to protoDataStore
        )

    }.asLiveDataOnDefault()

}