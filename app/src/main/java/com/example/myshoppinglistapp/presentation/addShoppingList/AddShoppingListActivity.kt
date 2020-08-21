package com.example.myshoppinglistapp.presentation.addShoppingList

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.presentation.BaseActivity
import com.example.myshoppinglistapp.presentation.shoppingList.adapter.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_add_shopping_list.*
import kotlinx.android.synthetic.main.activity_shopping_list.*
import java.util.*
import javax.inject.Inject

class AddShoppingListActivity : BaseActivity(), AddShoppingListContract.AddViewInterface {

    @Inject
    lateinit var addShoppingListPresenter: AddShoppingListPresenter

    override fun onStart() {
        super.onStart()
        addShoppingListPresenter.addShoppingLists()
        addFab.setOnClickListener { addShoppingLists() }
    }

    override fun onStop() {
        super.onStop()
        addShoppingListPresenter.stop()
    }

    override fun addShoppingLists(shoppingListName: String, shoppingListDate: Date, shoppingListArchived: Boolean) {
        val shoppingList = ShoppingList(name = shoppingListName, date = shoppingListDate, archived = shoppingListArchived)
    }

    override fun displayShoppingLists(shoppingList: List<ShoppingList>) {
        val addShoppingListAdapter = ShoppingListAdapter(shoppingList) {}
        shopping_list_recycler_view.apply {
            adapter = addShoppingListAdapter
            layoutManager = LinearLayoutManager(this@AddShoppingListActivity)
        }

        override fun addNewAddShoppingList() {
            startActivity(Intent(this,AddShoppingListActivity::class.java))
        }
    }
}