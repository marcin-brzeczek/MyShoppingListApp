package com.example.myshoppinglistapp.data.repository

import com.example.myshoppinglistapp.data.dao.ShoppingItemDao
import com.example.myshoppinglistapp.data.model.ShoppingItem
import io.reactivex.Completable
import javax.inject.Inject

class ShoppingItemRepository @Inject constructor(val shoppingItemDao: ShoppingItemDao){

    fun getAllOrderByDate(shoppingItemId: Long) = shoppingItemDao.getAllOrderByDate(shoppingItemId)

    fun delete(shoppingItemId: Long): Completable = shoppingItemDao.delete(shoppingItemId)

    fun update(shoppingItemId: Long, name:String) = shoppingItemDao.update(shoppingItemId, name)

    fun insert(shoppingItem: ShoppingItem) = shoppingItemDao.insert(shoppingItem)
}