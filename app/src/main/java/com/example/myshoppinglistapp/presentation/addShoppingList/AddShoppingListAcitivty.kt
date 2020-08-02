package com.example.myshoppinglistapp.presentation.addShoppingList

import android.os.Bundle
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_add_shopping_list.*

class AddShoppingListAcitivty : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopping_list)

        save.setOnClickListener { finish() }
    }
}