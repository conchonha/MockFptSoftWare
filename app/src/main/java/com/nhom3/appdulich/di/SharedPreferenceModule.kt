package com.nhom3.appdulich.di

import android.content.Context
import android.content.SharedPreferences
import com.nhom3.appdulich.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferenceModule {
    @Provides
    @Singleton
    fun provideSharePreference(context: Context): SharedPreferences =
        context.getSharedPreferences(Const.NAME_SHARE_PREFS, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
        sharedPreferences.edit()
}