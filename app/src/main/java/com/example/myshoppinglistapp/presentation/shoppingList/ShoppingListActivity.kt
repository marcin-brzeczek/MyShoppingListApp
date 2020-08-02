package com.example.myshoppinglistapp.presentation.shoppingList

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.presentation.BaseActivity
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListAcitivty
import com.example.myshoppinglistapp.presentation.shoppingList.adapter.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_shopping_list.*
import javax.inject.Inject

class ShoppingListActivity : BaseActivity(), ShoppingListContract.ViewInterface {

    @Inject
    lateinit var shoppingListPresenter: ShoppingListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
    }

    override fun onStart() {
        super.onStart()
        shoppingListPresenter.getShoppingLists()
        addFab.setOnClickListener { addNewShoppingList() }
    }

    override fun onStop() {
        super.onStop()
        shoppingListPresenter.stop()
    }

    override fun displayShoppingLists(shoppingLists: List<ShoppingList>) {
        val shoppingListAdapter = ShoppingListAdapter(shoppingLists) {}
        shopping_list_recycler_view.apply {
            adapter = shoppingListAdapter
            layoutManager = LinearLayoutManager(this@ShoppingListActivity)
        }
    }

    override fun addNewShoppingList() {
       startActivity(Intent(this, AddShoppingListAcitivty::class.java))
    }
}
