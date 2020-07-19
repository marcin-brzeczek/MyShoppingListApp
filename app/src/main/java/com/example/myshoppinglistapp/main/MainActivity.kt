package com.example.myshoppinglistapp.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.shoppinglist.ShoppingListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_next.setOnClickListener {
            startActivity(Intent(this@MainActivity, ShoppingListActivity::class.java))
        }
    }
}
