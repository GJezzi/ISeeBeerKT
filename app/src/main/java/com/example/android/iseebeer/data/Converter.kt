package com.example.android.iseebeer.data

import android.arch.persistence.room.TypeConverter
import com.example.android.iseebeer.data.model.PlaceInfo
import com.google.android.gms.location.places.Place

class Converter {

    @TypeConverter
    fun fromPlace(place: Place?) : PlaceInfo? {
        return if (place == null) null else PlaceInfo(place.id, place.name.toString(), place.address.toString())
    }
}