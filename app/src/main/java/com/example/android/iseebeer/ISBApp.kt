package com.example.android.iseebeer

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import com.example.android.iseebeer.data.database.ISBDataBase
import com.example.android.iseebeer.di.component.AppComponent
import com.example.android.iseebeer.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ISBApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

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

        ISBApp.database = Room.databaseBuilder(this, ISBDataBase::class.java,"places").build()
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector
}