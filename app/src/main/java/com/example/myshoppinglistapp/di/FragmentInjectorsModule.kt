package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.di.current.CurrentListPresenterModule
import com.example.myshoppinglistapp.di.current.CurrentListViewModule
import com.example.myshoppinglistapp.presentation.current.CurrentListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector(modules = [CurrentListPresenterModule::class, CurrentListViewModule::class])
    abstract fun provideCurrentListFragment(): CurrentListFragment
}