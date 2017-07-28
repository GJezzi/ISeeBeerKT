package com.example.android.iseebeer.model

import android.arch.persistence.room.*
import com.google.android.gms.location.places.Place
import io.reactivex.Flowable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM isb_database")
    fun getPlaces(): Flowable<List<Place>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(place: Place)

    @Delete
    fun delete(place: Place)

}

