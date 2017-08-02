package com.example.android.iseebeer.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.android.iseebeer.data.Converter
import com.example.android.iseebeer.data.model.PlaceInfo

@Database(entities = arrayOf(PlaceInfo::class), version = 1)
@TypeConverters(Converter::class)
abstract class ISBDataBase : RoomDatabase() {

    abstract fun placeDao(): PlaceDao

}
