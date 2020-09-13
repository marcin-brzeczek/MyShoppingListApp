package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListContract
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListPresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArchShoppingListPresenterModule {

    @Singleton
    @Provides
    fun providesArchShoppingListPresenter(
        archScheduler: SchedulerProvider,
        archShoppingListRepository: ShoppingListRepository,
        archView: ArchiveShoppingListContract.ArchViewInterface
    ) : ArchiveShoppingListContract.ArchivePresenterInterface = ArchiveShoppingListPresenter(archShoppingListRepository, archScheduler, archView)
}