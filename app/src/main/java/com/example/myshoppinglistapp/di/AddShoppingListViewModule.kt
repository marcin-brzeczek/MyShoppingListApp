package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListAcitivty
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListContract
import dagger.Binds
import dagger.Module

@Module
abstract class AddShoppingListViewModule {
    
    @Binds
    abstract fun provideAddShoppingListView(shoppingAddListActivity: AddShoppingListAcitivty): AddShoppingListContract.AddViewInterface
}