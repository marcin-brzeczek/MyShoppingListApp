package com.example.myshoppinglistapp.di.archShoppingList

import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListContract

import dagger.Binds
import dagger.Module

@Module
abstract class ArchShoppingListViewModule {

    @Binds
    abstract fun provideArchShoppingListView(archiveShoppingListActivity: ArchiveShoppingListActivity) : ArchiveShoppingListContract.ArchViewInterface
}
