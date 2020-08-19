package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListContract
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListPresenter
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListContract
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Provides
import javax.inject.Singleton

class AddShoppingListPresenterModule {

    @Singleton
    @Provides
    fun providesAddShoppingListPresenter(
        scheduler: SchedulerProvider,
        shoppingListRepository: ShoppingListRepository,
        view: AddShoppingListContract.AddViewInterface
        ): AddShoppingListContract.AddPresenterInterface = AddShoppingListPresenter(shoppingListRepository, scheduler, view)

}