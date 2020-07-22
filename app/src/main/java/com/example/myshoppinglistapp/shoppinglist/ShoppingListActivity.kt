package com.example.myshoppinglistapp.shoppinglist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.shoppingListDetails.ShoppingListDetailsActivity
import com.example.myshoppinglistapp.shoppinglist.adapter.ShoppingListAdapter
import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList
import kotlinx.android.synthetic.main.activity_shopping_list.*

const val SHOPPING_LIST_NAME = "SHOPPING_LIST_NAME"

class ShoppingListActivity : AppCompatActivity(), ShoppingListContract.ViewInterface {

    private lateinit var shoppingListPresenter: ShoppingListContract.PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        setupPresenter()
    }

    private fun setupPresenter() {
        shoppingListPresenter =
            ShoppingListPresenter(
                this
            )
    }

    override fun onStart() {
        super.onStart()
        shoppingListPresenter.getShoppingLists()
    }

    override fun displayShoppingLists(shoppingLists: List<ShoppingList>) {
        val shoppingListAdapter = ShoppingListAdapter(shoppingLists) { shoppingList ->
            startActivity(Intent(this, ShoppingListDetailsActivity::class.java).apply {
                putExtra(SHOPPING_LIST_NAME, shoppingList.name)
            })
        }
        shopping_list_recycler_view.apply {
            adapter = shoppingListAdapter
            layoutManager = LinearLayoutManager(this@ShoppingListActivity)
        }
    }
}
