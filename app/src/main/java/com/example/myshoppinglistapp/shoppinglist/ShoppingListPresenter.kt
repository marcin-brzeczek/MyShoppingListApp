package com.example.myshoppinglistapp.shoppinglist

import com.example.myshoppinglistapp.shoppinglist.data.localSource.ShoppingListLocalSource
import com.example.myshoppinglistapp.shoppinglist.ShoppingListContract
import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList

class ShoppingListPresenter (
    private val viewInterface: ShoppingListContract.ViewInterface
) : ShoppingListContract.PresenterInterface {

    override fun getShoppingLists() {
        val shoppingList = ShoppingListLocalSource.getShoppingLists()
        viewInterface.displayShoppingLists(shoppingList)
    }
}