package com.example.myshoppinglistapp.presentation.archivedShoppingList


class ArchivedShoppingListContract {
    interface ArchivedPresenterInterface {
        fun archiveAddShoppingList(shoppingListName: String)
    }

    interface ArchivedViewInterface {
        fun navigateToShoppingLists()
    }
}