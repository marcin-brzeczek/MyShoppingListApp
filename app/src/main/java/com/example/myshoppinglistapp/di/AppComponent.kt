package com.example.myshoppinglistapp.di

import android.app.Application
import com.example.myshoppinglistapp.InitApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        RoomModule::class,
        SchedulerProviderModule::class,
        ActivityInjectorsModule::class]
)
interface AppComponent : AndroidInjector<InitApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}