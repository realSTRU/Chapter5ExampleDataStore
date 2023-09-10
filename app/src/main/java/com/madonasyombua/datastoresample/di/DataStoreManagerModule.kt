package com.madonasyombua.datastoresample.di

import com.madonasyombua.datastoresample.data.DataStoreManager
import com.madonasyombua.datastoresample.data.DataStoreManagerImpl
import com.madonasyombua.datastoresample.mediator.TaskService
import com.madonasyombua.datastoresample.mediator.TaskServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreManagerModule {

    @Singleton
    @Binds
    abstract fun bindDataStoreRepository(dataStoreManagerImpl: DataStoreManagerImpl): DataStoreManager

    @Singleton
    @Binds
    abstract fun bindTaskService(taskServiceImpl: TaskServiceImpl): TaskService
}