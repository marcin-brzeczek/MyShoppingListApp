package com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.presentation.base.BaseActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchivedShoppingListActivity
import com.example.myshoppinglistapp.presentation.archivedShoppingList.adapterAddArchived.ArchivedAddShoppingListAdapter
import kotlinx.android.synthetic.main.activity_archive_shopping_list.*
import javax.inject.Inject

class ArchiveShoppingListActivity: BaseActivity(), ArchiveShoppingListContract.ArchViewInterface {

    @Inject
    lateinit var archiveShoppingListPresenter: ArchiveShoppingListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive_shopping_list)
    }

    override fun onStart() {
        super.onStart()
        archiveShoppingListPresenter.getArchiveShoppingLists()
        archFab.setOnClickListener { addArchiveNewShoppingList() }
    }

    override fun onStop() {
        super.onStop()
        archiveShoppingListPresenter.stop()
    }

    override fun displayArchiveShoppingLists(shoppingList: List<ShoppingList>) {
        val archiveShoppingListAdapter = ArchivedAddShoppingListAdapter(shoppingList) {}
        archive_list_recycler_view.apply {
            adapter = archiveShoppingListAdapter
            layoutManager = LinearLayoutManager(this@ArchiveShoppingListActivity)
        }
    }

    override fun addArchiveNewShoppingList() {
        startActivity(Intent(this, ArchivedShoppingListActivity::class.java))
    }
}