package com.nhom3.appdulich.di

import android.content.Context
import com.nhom3.appdulich.utils.Notification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingleToneModule {
//    @Provides
//    @Singleton
//    fun provideNotification(@ApplicationContext context: Context) : Notification = Notification(context)
}