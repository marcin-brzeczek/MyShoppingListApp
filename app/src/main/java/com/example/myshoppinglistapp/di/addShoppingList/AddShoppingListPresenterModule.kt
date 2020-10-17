package com.example.myshoppinglistapp.di.addShoppingList

import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListContract
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AddShoppingListPresenterModule {

    @Singleton
    @Provides
    fun providesAddShoppingListPresenter(
        scheduler: SchedulerProvider,
        shoppingListRepository: ShoppingListRepository,
        view: AddShoppingListContract.AddViewInterface
        ): AddShoppingListContract.AddPresenterInterface = AddShoppingListPresenter(shoppingListRepository, scheduler, view)

}