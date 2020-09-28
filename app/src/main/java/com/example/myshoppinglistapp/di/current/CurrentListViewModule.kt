package com.example.myshoppinglistapp.di.current

import com.example.myshoppinglistapp.presentation.current.CurrentListContract
import com.example.myshoppinglistapp.presentation.current.CurrentListFragment
import dagger.Binds
import dagger.Module

@Module
abstract class CurrentListViewModule {

    @Binds
    abstract fun provideCurrentFragmentView(currentListFragment: CurrentListFragment): CurrentListContract.ViewInterface
}