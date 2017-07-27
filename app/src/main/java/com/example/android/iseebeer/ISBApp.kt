package com.example.android.iseebeer

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import com.example.android.iseebeer.data.ISBDataBase
import com.example.android.iseebeer.data.PlaceData
import com.example.android.iseebeer.di.AppComponent
import com.example.android.iseebeer.di.DaggerAppComponent
import com.google.android.gms.location.places.Place
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ISBApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var place: Place

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .build()
    }

    companion object {
        var database: ISBDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        ISBApp.database = Room.databaseBuilder(this, ISBDataBase::class.java, "isb_database").allowMainThreadQueries().build()

        ISBApp.database?.placeDao()?.insert(place)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector
}