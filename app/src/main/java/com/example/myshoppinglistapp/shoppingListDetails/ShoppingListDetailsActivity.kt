package com.example.myshoppinglistapp.shoppingListDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.shoppinglist.SHOPPING_LIST_NAME
import kotlinx.android.synthetic.main.activity_shoppinglist_details.title as shoppingTitle

class ShoppingListDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppinglist_details)
        displayShoppingListDetails()
    }

    fun displayShoppingListDetails() {
        shoppingTitle.text = intent.getStringExtra(SHOPPING_LIST_NAME)
    }
}