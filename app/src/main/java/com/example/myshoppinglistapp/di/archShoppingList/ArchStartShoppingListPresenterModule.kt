package com.example.myshoppinglistapp.di.archShoppingList

import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListContract
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ArchStartShoppingListPresenterModule {

    @Singleton
    @Provides
    fun providesArchStartShoppingListPresenter(
        archStartScheduler: SchedulerProvider,
        archStartShoppingListRepository: ShoppingListRepository,
        archStartView: ArchivedShoppingListContract.ArchivedViewInterface
    ) : ArchivedShoppingListContract.ArchivedPresenterInterface = ArchivedShoppingListPresenter(archStartShoppingListRepository, archStartScheduler, archStartView)
}