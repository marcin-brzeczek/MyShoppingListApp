package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListContract
import dagger.Binds
import dagger.Module

@Module
abstract class ArchStartShoppingListViewModule {

    @Binds
    abstract fun provideStartArchShoppingListView(archivedShoppingListActivity: ArchivedShoppingListActivity) : ArchivedShoppingListContract.ArchivedViewInterface
}