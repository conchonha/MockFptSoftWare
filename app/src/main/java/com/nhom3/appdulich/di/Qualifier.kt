package com.nhom3.appdulich.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainCoroutineScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IOCoroutineScope