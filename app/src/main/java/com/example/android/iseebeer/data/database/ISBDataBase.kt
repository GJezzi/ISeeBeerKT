package com.example.android.iseebeer.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.android.iseebeer.data.model.PlaceInfo

@Database(entities = arrayOf(PlaceInfo::class), version = 1)
abstract class ISBDataBase : RoomDatabase() {

    abstract fun placeDao(): PlaceDao

}
