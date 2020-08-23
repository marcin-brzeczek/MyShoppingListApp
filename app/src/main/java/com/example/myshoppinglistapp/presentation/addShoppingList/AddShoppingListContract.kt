package com.example.myshoppinglistapp.presentation.addShoppingList

class AddShoppingListContract {
    interface AddPresenterInterface {
        fun addShoppingList(shoppingListName: String)
    }

    interface AddViewInterface {
        fun navigateToShoppingLists()
    }
}
