package com.example.myshoppinglistapp.presentation.addShoppingList

import com.example.myshoppinglistapp.data.model.ShoppingList

class AddShoppingListContract {
    interface AddPresenterInterface {
        fun addShoppingLists(shoppingListName: String)
    }

    interface AddViewInterface {
        fun displayShoppingLists(shoppingList: List<ShoppingList>)
        fun addNewShoppingList()

    }
}
