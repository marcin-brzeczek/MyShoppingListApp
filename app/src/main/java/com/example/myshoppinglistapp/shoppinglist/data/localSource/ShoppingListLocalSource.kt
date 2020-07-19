package com.example.myshoppinglistapp.shoppinglist.data.localSource

import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList

object ShoppingListLocalSource {

    fun getShoppingLists(): List<ShoppingList> {
        val shoppingLists = mutableListOf<ShoppingList>()
        (1..50).forEach { number ->
            shoppingLists.add(ShoppingList("Vegetables $number"))
        }
        return shoppingLists
    }
}