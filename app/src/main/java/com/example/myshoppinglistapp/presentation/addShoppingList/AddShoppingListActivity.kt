package com.example.myshoppinglistapp.presentation.addShoppingList

import android.os.Bundle
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_add_shopping_list.*
import javax.inject.Inject

class AddShoppingListActivity : BaseActivity(), AddShoppingListContract.AddViewInterface {

    @Inject
    lateinit var addShoppingListPresenter: AddShoppingListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopping_list)

        save.setOnClickListener { addShoppingListPresenter.addShoppingList(input_edittext.text.toString()) }
    }

    override fun onStop() {
        super.onStop()
        addShoppingListPresenter.stop()
    }

    override fun navigateToShoppingLists() {
        finish()
    }

}