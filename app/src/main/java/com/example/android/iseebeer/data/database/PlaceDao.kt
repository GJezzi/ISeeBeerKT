package com.example.android.iseebeer.data.database

import android.arch.persistence.room.*
import com.example.android.iseebeer.data.model.PlaceInfo
import io.reactivex.Flowable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM isb_database")
    fun getPlaces(): Flowable<List<PlaceInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(placeInfo: PlaceInfo)

    @Delete
    fun delete(placeInfo: PlaceInfo)

}



