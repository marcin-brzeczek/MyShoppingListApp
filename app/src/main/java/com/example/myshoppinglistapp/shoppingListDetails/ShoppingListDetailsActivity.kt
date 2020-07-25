package com.example.myshoppinglistapp.shoppingListDetails

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.shoppinglist.SHOPPING_LIST_NAME
import com.example.myshoppinglistapp.shoppinglist.adapter.ShoppingListAdapter
import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList
import kotlinx.android.synthetic.main.activity_shoppinglist_details.title as shoppingTitle

class ShoppingListDetailsActivity : AppCompatActivity(), ShoppingListDetailsContract.ViewDetailsInterface {

    private lateinit var shoppingListDetailsPresenter: ShoppingListDetailsContract.PresenterDetailsInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppinglist_details)
        setupPresenterDetails()
    }

    private fun  setupPresenterDetails() {
        shoppingListDetailsPresenter =
            ShoppingListDetailsPresenter(
                this
            )
    }

    override fun onStart() {
        super.onStart()
        shoppingListDetailsPresenter.getShoppingListsDetails()
    }
    override fun displayShoppingListsDetails(shoppinglist: List<ShoppingList>) {
        shoppingTitle.text = intent.getStringExtra(SHOPPING_LIST_NAME)

} }