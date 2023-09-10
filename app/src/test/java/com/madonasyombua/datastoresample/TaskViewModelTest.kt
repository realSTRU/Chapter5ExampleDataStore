package com.madonasyombua.datastoresample

import com.madonasyombua.datastoresample.data.Tasks
import com.madonasyombua.datastoresample.mediator.TaskService
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TaskViewModelTest {
    private lateinit var classToTest: TaskViewModel
    private val mockTaskService = mockk<TaskService>(relaxed = true)

    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp(){
        classToTest = TaskViewModel(mockTaskService)
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `verify add task function adds tasks as needed`() = runBlocking {
        val fakeTasks = Tasks(
            firstTask = "finish school work",
            secondTask = "buy gifts for the holiday",
            thirdTask = "finish work"
        )
        val expected = classToTest.saveTaskData(fakeTasks)

        Assert.assertNotNull(expected)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}