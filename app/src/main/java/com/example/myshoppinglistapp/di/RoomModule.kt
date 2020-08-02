package com.example.myshoppinglistapp.di

import android.app.Application
import androidx.room.Room
import com.example.myshoppinglistapp.data.dao.ShoppingListDao
import com.example.myshoppinglistapp.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "ShoppingListDatabase"

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .build()

    @Singleton
    @Provides
    fun providesShoppingListDao(appDatabase: AppDatabase): ShoppingListDao =
        appDatabase.shoppingListDao()

}