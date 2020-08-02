package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListContract
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ShoppingListPresenterModule {

    @Singleton
    @Provides
    fun providesShoppingListPresenter(
        scheduler:SchedulerProvider,
        shoppingListRepository: ShoppingListRepository,
        view: ShoppingListContract.ViewInterface
    ): ShoppingListContract.PresenterInterface = ShoppingListPresenter(shoppingListRepository, scheduler, view)

}