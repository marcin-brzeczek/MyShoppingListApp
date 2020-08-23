package com.example.myshoppinglistapp.data.repository

import com.example.myshoppinglistapp.data.dao.ShoppingListDao
import com.example.myshoppinglistapp.data.model.ShoppingList
import javax.inject.Inject

class ShoppingListRepository @Inject constructor(val shoppingListDao: ShoppingListDao) {

    fun getAllOrderedByDate(archived: Boolean) = shoppingListDao.getAllCurrentOrderByDate(archived)

    fun add(shoppingList: ShoppingList) = shoppingListDao.add(shoppingList)
}