package com.example.android.iseebeer

import android.app.Activity
import android.app.Application
import com.example.android.iseebeer.di.AppContext
import com.example.android.iseebeer.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ISBApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        AppContext.appComponent = DaggerAppComponent.builder().build()
        AppContext.appComponent.inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector
}