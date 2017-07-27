package com.example.android.iseebeer.di

import com.example.android.iseebeer.ISBApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class))

interface AppComponent : AndroidInjector<ISBApp> {

    //fun inject(isbApp: ISBApp)
}