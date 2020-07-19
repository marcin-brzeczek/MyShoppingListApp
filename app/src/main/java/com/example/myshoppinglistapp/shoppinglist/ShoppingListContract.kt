package com.example.myshoppinglistapp.shoppinglist

import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList

class ShoppingListContract {
    interface PresenterInterface {
        fun getShoppingLists()
    }

    interface ViewInterface {
        fun displayShoppingLists(shoppingList: List<ShoppingList>)
    }
}
