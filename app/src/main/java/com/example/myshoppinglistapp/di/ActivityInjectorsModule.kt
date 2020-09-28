package com.example.myshoppinglistapp.di


import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListActivity
import com.example.myshoppinglistapp.presentation.shoppingListStale.ShoppingListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector(modules = [ShoppingListPresenterModule::class, ShoppingListViewModule::class])
    abstract fun provideShoppingListActivity(): ShoppingListActivity

    @ContributesAndroidInjector(modules = [AddShoppingListPresenterModule::class, AddShoppingListViewModule::class])
    abstract fun provideAddShoppingListActivity(): AddShoppingListActivity

    @ContributesAndroidInjector(modules = [ArchShoppingListPresenterModule::class, ArchShoppingListViewModule::class])
    abstract fun provideArchShoppingListActivity(): ArchiveShoppingListActivity

    @ContributesAndroidInjector(modules = [ArchStartShoppingListPresenterModule::class, ArchStartShoppingListViewModule::class])
    abstract fun provideArchStartShoppingListActivity(): ArchivedShoppingListActivity

}