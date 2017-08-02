package com.example.android.iseebeer.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.example.android.iseebeer.data.database.ISBDataBase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun providesDatabase(context: Context): ISBDataBase = Room.databaseBuilder(context, ISBDataBase::class.java,"places").build()

    @Provides
    fun providesPlaceDao(isbDataBase: ISBDataBase) = isbDataBase.placeDao()
}