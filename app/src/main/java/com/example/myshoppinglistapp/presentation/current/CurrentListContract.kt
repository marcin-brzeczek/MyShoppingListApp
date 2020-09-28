package com.example.myshoppinglistapp.presentation.current

import com.example.myshoppinglistapp.data.model.ShoppingList

class CurrentListContract {
    interface PresenterInterface {
        fun getShoppingLists()
    }

    interface ViewInterface {
        fun displayShoppingLists(shoppingList: List<ShoppingList>)
        fun addNewShoppingList()
    }
}
