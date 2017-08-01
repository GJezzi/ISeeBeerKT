package com.example.android.iseebeer.di.component

import com.example.android.iseebeer.ISBApp
import com.example.android.iseebeer.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class))

interface AppComponent : AndroidInjector<ISBApp> {

    override fun inject(isbApp: ISBApp)
}