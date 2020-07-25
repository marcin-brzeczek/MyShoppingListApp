package com.example.myshoppinglistapp.shoppingListDetails

import com.example.myshoppinglistapp.shoppinglist.data.localSource.ShoppingListLocalSource

class ShoppingListDetailsPresenter (
    private val viewDetailsInterface:ShoppingListDetailsContract.ViewDetailsInterface
) : ShoppingListDetailsContract.PresenterDetailsInterface {

    override fun getShoppingListsDetails() {
        val shoppingListsDetails = ShoppingListLocalSource.getShoppingLists()
        viewDetailsInterface.displayShoppingListsDetails(shoppingListsDetails)
    }
}