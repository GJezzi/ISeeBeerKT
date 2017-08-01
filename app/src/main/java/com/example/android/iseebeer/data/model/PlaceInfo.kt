package com.example.android.iseebeer.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "places")
data class PlaceInfo(
        @PrimaryKey
        val placeId: String,

        @ColumnInfo(name = "place_name")
        val placeName: String,

        @ColumnInfo(name = "place_address")
        val placeAddress: String
)
