package com.example.android.iseebeer.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.example.android.iseebeer.data.database.ISBDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ISBDataBase = Room.databaseBuilder(context, ISBDataBase::class.java,"places").build()

    @Provides
    @Singleton
    fun providePlaceDao(isbDataBase: ISBDataBase) = isbDataBase.placeDao()
}