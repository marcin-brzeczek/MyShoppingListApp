package com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList

import com.example.myshoppinglistapp.data.model.ShoppingList

class ArchiveShoppingListContract {
    interface ArchivePresenterInterface {
        fun getArchiveShoppingLists()
    }

    interface ArchViewInterface {
        fun displayArchiveShoppingLists(shoppingList: List<ShoppingList>)
        fun addArchiveNewShoppingList()
    }
}