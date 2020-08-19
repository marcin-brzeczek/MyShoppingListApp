package com.example.myshoppinglistapp.di

import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListAcitivty
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListActivity
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector(modules = [ShoppingListPresenterModule::class, ShoppingListViewModule::class])
    abstract fun provideShoppingListActivity(): ShoppingListActivity

    @ContributesAndroidInjector()
    abstract fun provideAddShoppingListActivity(): AddShoppingListActivity

    @ContributesAndroidInjector(modules = [AddShoppingListPresenterModule::class, AddShoppingListViewModule::class])
    abstract fun providesAddShoppingListPresenter(): ShoppingListActivity
}