package com.example.myshoppinglistapp.presentation.shoppingListStale

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.presentation.base.BaseActivity
import com.example.myshoppinglistapp.presentation.addShoppingList.AddShoppingListActivity
import com.example.myshoppinglistapp.presentation.current.CurrentListContract
import com.example.myshoppinglistapp.presentation.current.CurrentListPresenter
import com.example.myshoppinglistapp.presentation.current.adapter.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_shopping_list.*
import javax.inject.Inject

class ShoppingListActivity : BaseActivity(), CurrentListContract.ViewInterface {

    @Inject
    lateinit var currentListPresenter: CurrentListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
    }

    override fun onStart() {
        super.onStart()
        currentListPresenter.getShoppingLists()
        addFab.setOnClickListener { addNewShoppingList() }
    }

    override fun onStop() {
        super.onStop()
        currentListPresenter.stop()
    }

    override fun displayShoppingLists(shoppingLists: List<ShoppingList>) {
        val shoppingListAdapter = ShoppingListAdapter(shoppingLists) {}
        shopping_list_recycler_view.apply {
            adapter = shoppingListAdapter
            layoutManager = LinearLayoutManager(this@ShoppingListActivity)
        }
    }

    override fun addNewShoppingList() {
        startActivity(Intent(this, AddShoppingListActivity::class.java))
    }
}
