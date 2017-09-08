package com.example.android.iseebeer.di.module

import android.content.Context
import com.example.android.iseebeer.ISBApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val isbApp: ISBApp) {

    @Singleton
    @Provides
    fun provideApp() = isbApp

    @Provides
    @Singleton
    fun provideContext(context: Context) = context
}