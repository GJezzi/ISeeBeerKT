package com.example.android.iseebeer.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "isb_database")
class PlaceData (

        @PrimaryKey(autoGenerate = true)
        val placeId: Long = 0,

        @ColumnInfo(name = "place_name")
        val placeName: String,

        @ColumnInfo(name = "place_address")
        val placeAddress: String
)


