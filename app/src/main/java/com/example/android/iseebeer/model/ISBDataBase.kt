package com.example.android.iseebeer.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(PlaceData::class), version = 1)
abstract class ISBDataBase : RoomDatabase() {

    val DATABASE_NAME: String = "isb_database"

    abstract fun placeDao(): PlaceDao

}
