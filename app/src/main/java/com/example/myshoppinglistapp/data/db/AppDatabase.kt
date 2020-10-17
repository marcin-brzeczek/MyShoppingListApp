package com.example.myshoppinglistapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myshoppinglistapp.data.dao.ShoppingItemDao
import com.example.myshoppinglistapp.data.dao.ShoppingListDao
import com.example.myshoppinglistapp.data.model.ShoppingList

@TypeConverters(RoomTypeConverters::class)
@Database(entities = [ShoppingList::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shoppingListDao(): ShoppingListDao
    abstract fun shoppingItemDao(): ShoppingItemDao
}