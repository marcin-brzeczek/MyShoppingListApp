package com.example.myshoppinglistapp.presentation.menu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList.ArchiveShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListActivity
import com.example.myshoppinglistapp.presentation.shoppingList.ShoppingListActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.current -> startActivity(Intent(this, ShoppingListActivity::class.java))
            R.id.archive -> startActivity(Intent(this, ArchiveShoppingListActivity::class.java))
        }
        return true
    }
}