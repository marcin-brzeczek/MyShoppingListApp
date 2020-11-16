package com.example.myshoppinglistapp.di

import android.app.Application
import com.example.myshoppinglistapp.InitApp
import com.example.myshoppinglistapp.di.injectors.ActivityInjectorsModule
import com.example.myshoppinglistapp.di.injectors.FragmentInjectorsModule
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
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class]
)
interface AppComponent : AndroidInjector<InitApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}