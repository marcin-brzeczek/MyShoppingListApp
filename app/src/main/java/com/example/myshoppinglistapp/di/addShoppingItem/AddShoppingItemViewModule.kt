package com.example.myshoppinglistapp.di.addShoppingItem

import com.example.myshoppinglistapp.presentation.addShoppingItem.AddShoppingItemActivity
import com.example.myshoppinglistapp.presentation.addShoppingItem.AddShoppingItemContract
import dagger.Binds
import dagger.Module


    @Module
    abstract class AddShoppingItemViewModule {

        @Binds
        abstract fun provideAddShoppingItemView(shoppingItemActivity: AddShoppingItemActivity): AddShoppingItemContract.AddViewInterface
    }
