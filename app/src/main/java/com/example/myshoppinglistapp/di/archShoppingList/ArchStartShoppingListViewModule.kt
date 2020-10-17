package com.example.myshoppinglistapp.di.archShoppingList

import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListContract
import dagger.Binds
import dagger.Module

@Module
abstract class ArchStartShoppingListViewModule {

    @Binds
    abstract fun provideStartArchShoppingListView(archivedShoppingListActivity: ArchivedShoppingListActivity) : ArchivedShoppingListContract.ArchivedViewInterface
}