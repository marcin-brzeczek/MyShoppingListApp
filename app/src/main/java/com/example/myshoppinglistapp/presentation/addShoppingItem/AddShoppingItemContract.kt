package com.example.myshoppinglistapp.presentation.addShoppingItem

class AddShoppingItemContract {
    interface  AddPresenterInterface {
        fun addShoppingItem(shoppingItemName: String)
    }

    interface AddViewInterface {
        fun navigateToShoppingItems()
    }
}