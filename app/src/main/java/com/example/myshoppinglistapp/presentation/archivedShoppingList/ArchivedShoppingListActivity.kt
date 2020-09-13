package com.example.myshoppinglistapp.presentation.archivedShoppingList

import android.os.Bundle
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.presentation.BaseActivity
import kotlinx.android.synthetic.main.archive_shopping_list.*
import javax.inject.Inject

class ArchivedShoppingListActivity : BaseActivity(), ArchivedShoppingListContract.ArchivedViewInterface {

    @Inject
    lateinit var archivedShoppingListPresenter: ArchivedShoppingListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.archive_shopping_list)

        archSave.setOnClickListener { archivedShoppingListPresenter.archiveAddShoppingList(input_archiveedittext.text.toString()) }
    }

    override fun onStop() {
        super.onStop()
        archivedShoppingListPresenter.stop()
    }

    override fun navigateToShoppingLists() {
        finish()
    }
}


