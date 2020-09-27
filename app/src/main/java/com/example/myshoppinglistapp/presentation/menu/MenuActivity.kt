package com.example.myshoppinglistapp.presentation.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        if (savedInstanceState == null)
            setupNavigation()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val tabIds = listOf(R.navigation.current, R.navigation.archive)
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = tabIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        controller.observe(this, Observer { navigationController ->
            setupActionBarWithNavController(navigationController)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}