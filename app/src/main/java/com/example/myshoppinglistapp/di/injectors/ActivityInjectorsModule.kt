package com.example.myshoppinglistapp.di.injectors


import com.example.myshoppinglistapp.di.addShoppingItem.AddShoppingItemPresenterModule
import com.example.myshoppinglistapp.di.addShoppingItem.AddShoppingItemViewModule
import com.example.myshoppinglistapp.di.addShoppingList.AddShoppingListPresenterModule
import com.example.myshoppinglistapp.di.addShoppingList.AddShoppingListViewModule
import com.example.myshoppinglistapp.di.archShoppingList.ArchShoppingListPresenterModule
import com.example.myshoppinglistapp.di.archShoppingList.ArchShoppingListViewModule
import com.example.myshoppinglistapp.di.archShoppingList.ArchStartShoppingListPresenterModule
import com.example.myshoppinglistapp.di.archShoppingList.ArchStartShoppingListViewModule
import com.example.myshoppinglistapp.di.shoppingList.ShoppingListPresenterModule
import com.example.myshoppinglistapp.di.shoppingList.ShoppingListViewModule
import com.example.myshoppinglistapp.presentation.addShoppingItem.AddShoppingItemActivity
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

    @ContributesAndroidInjector(modules = [AddShoppingItemPresenterModule::class, AddShoppingItemViewModule::class])
    abstract fun providerAddShoppingItemActivity(): AddShoppingItemActivity

    @ContributesAndroidInjector(modules = [ArchShoppingListPresenterModule::class, ArchShoppingListViewModule::class])
    abstract fun provideArchShoppingListActivity(): ArchiveShoppingListActivity

    @ContributesAndroidInjector(modules = [ArchStartShoppingListPresenterModule::class, ArchStartShoppingListViewModule::class])
    abstract fun provideArchStartShoppingListActivity(): ArchivedShoppingListActivity

}