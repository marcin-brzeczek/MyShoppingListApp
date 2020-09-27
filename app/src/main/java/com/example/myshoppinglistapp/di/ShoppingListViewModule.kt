package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.presentation.current.CurrentListContract
import com.example.myshoppinglistapp.presentation.shoppingListStale.ShoppingListActivity
import dagger.Binds
import dagger.Module

@Module
abstract class ShoppingListViewModule {

    @Binds
    abstract fun provideShoppingListView(shoppingListActivity: ShoppingListActivity): CurrentListContract.ViewInterface
}