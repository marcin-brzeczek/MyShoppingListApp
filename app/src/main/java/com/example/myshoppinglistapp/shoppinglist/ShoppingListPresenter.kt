package com.example.myshoppinglistapp.shoppinglist

import com.example.myshoppinglistapp.shoppingListDetails.ShoppingListDetailsContract
import com.example.myshoppinglistapp.shoppinglist.data.localSource.ShoppingListLocalSource

class ShoppingListPresenter(
    private val viewInterface: ShoppingListActivity
) : ShoppingListContract.PresenterInterface {

    override fun getShoppingLists() {
        val shoppingList = ShoppingListLocalSource.getShoppingLists()
        viewInterface.displayShoppingLists(shoppingList)
    }
}