package com.example.myshoppinglistapp.presentation.addShoppingItem

import android.os.Bundle
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_shopping_list.*
import javax.inject.Inject

class AddShoppingItemActivity : BaseActivity(), AddShoppingItemContract.AddViewInterface {

    @Inject
    lateinit var addShoppingItemPresenter: AddShoppingItemPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopping_list)

        save.setOnClickListener { addShoppingItemPresenter.addShoppingItem(input_edittext.text.toString()) }
    }

    override fun onStop() {
        super.onStop()
        addShoppingItemPresenter.stop()
    }

    override fun navigateToShoppingItems() {
        finish()
    }
}