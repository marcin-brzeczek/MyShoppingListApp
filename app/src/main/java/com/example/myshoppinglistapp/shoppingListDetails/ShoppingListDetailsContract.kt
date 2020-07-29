package com.example.myshoppinglistapp.shoppingListDetails

import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList

class ShoppingListDetailsContract {
    interface PresenterDetailsInterface {
        fun getShoppingListsDetails()
    }

    interface ViewDetailsInterface {
        fun displayShoppingListsDetails(shoppingList: List<ShoppingList>)
    }
}