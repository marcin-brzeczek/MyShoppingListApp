package com.example.myshoppinglistapp.di.addShoppingItem

import com.example.myshoppinglistapp.data.repository.ShoppingItemRepository
import com.example.myshoppinglistapp.presentation.addShoppingItem.AddShoppingItemContract
import com.example.myshoppinglistapp.presentation.addShoppingItem.AddShoppingItemPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Provides
import javax.inject.Singleton

class AddShoppingItemPresenterModule {

    @Singleton
    @Provides
    fun providesAddShoppingItemPresenter(
        scheduler: SchedulerProvider,
        shoppingItemRepository: ShoppingItemRepository,
        view: AddShoppingItemContract.AddViewInterface
    ): AddShoppingItemContract.AddPresenterInterface = AddShoppingItemPresenter(shoppingItemRepository,scheduler, view)

}