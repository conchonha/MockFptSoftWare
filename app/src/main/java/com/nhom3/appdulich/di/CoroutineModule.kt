package com.example.sangtb_advanandroid_day1.di

import com.nhom3.appdulich.di.IOCoroutineScope
import com.nhom3.appdulich.di.MainCoroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {
    @IOCoroutineScope
    @Provides
    fun provideIOCoroutineScope() : CoroutineScope = CoroutineScope(SupervisorJob()+Dispatchers.IO)

    @MainCoroutineScope
    @Provides
    fun provideMainCoroutineScope() : CoroutineScope = CoroutineScope(SupervisorJob()+Dispatchers.Main)
}