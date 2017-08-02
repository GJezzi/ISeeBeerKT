package com.example.android.iseebeer.di.component

import com.example.android.iseebeer.ISBApp
import com.example.android.iseebeer.di.module.AppModule
import com.example.android.iseebeer.di.module.RoomModule
import com.example.android.iseebeer.ui.MainActivity
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        RoomModule::class,
        AppModule::class))

interface AppComponent : AndroidInjector<ISBApp> {

    override fun inject(isbApp: ISBApp)

    fun inject(mainActivity: MainActivity)


}