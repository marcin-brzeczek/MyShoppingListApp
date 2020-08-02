package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListActivity
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListContract
import dagger.Binds
import dagger.Module

@Module
abstract class ShoppingListViewModule {

    @Binds
    abstract fun provideShoppingListView(shoppingListActivity: ShoppingListActivity): ShoppingListContract.ViewInterface
}