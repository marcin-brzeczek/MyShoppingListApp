package com.example.myshoppinglistapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myshoppinglistapp.data.model.ShoppingList
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface ShoppingListDao {

    @Query("select * from shoppingLists where archived =:archived order by date desc")
    fun getAllCurrentOrderByDate(archived: Boolean): Observable<List<ShoppingList>>

    @Insert
    fun add(shoppingList: ShoppingList) : Completable
}