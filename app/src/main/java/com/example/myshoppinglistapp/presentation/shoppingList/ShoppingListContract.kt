package com.example.myshoppinglistapp.presentation.shoppingList

import com.example.myshoppinglistapp.data.model.ShoppingList

class ShoppingListContract {
    interface PresenterInterface {
        fun getShoppingLists()
    }

    interface ViewInterface {
        fun displayShoppingLists(shoppingList: List<ShoppingList>)
        fun addNewShoppingList()
    }
}
