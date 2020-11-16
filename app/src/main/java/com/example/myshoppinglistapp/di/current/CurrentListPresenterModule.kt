package com.example.myshoppinglistapp.di.current

import com.example.myshoppinglistapp.data.repository.ShoppingItemRepository
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.current.CurrentListContract
import com.example.myshoppinglistapp.presentation.current.CurrentListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CurrentListPresenterModule {

    @Singleton
    @Provides
    fun providesCurrentListPresenter(
        scheduler: SchedulerProvider,
        shoppingListRepository: ShoppingListRepository,
        view: CurrentListContract.ViewInterface
    ): CurrentListContract.PresenterInterface =
        CurrentListPresenter(
            shoppingListRepository,
            scheduler,
            view
        )

}