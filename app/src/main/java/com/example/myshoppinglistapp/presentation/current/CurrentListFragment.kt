package com.example.myshoppinglistapp.presentation.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.presentation.current.adapter.ShoppingListAdapter
import com.example.myshoppinglistapp.presentation.extensions.showShortToast
import com.example.myshoppinglistapp.utils.ItemSwipeHelperCallback
import com.example.myshoppinglistapp.utils.OnSwipeListener
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_shopping_list.*
import javax.inject.Inject

class CurrentListFragment : DaggerFragment(), CurrentListContract.ViewInterface, OnSwipeListener {

    @Inject
    lateinit var currentListPresenter: CurrentListPresenter

    private lateinit var shoppingListAdapter: ShoppingListAdapter

    private val itemTouchHelper by lazy {
        ItemTouchHelper(ItemSwipeHelperCallback(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_current, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentListPresenter.getShoppingLists()
        addFab.setOnClickListener { addNewShoppingList() }
    }

    override fun onStop() {
        super.onStop()
        currentListPresenter.stop()
    }

    override fun displayShoppingLists(shoppingLists: List<ShoppingList>) {
        shoppingListAdapter = ShoppingListAdapter(shoppingLists) {}
        shopping_list_recycler_view.apply {
            adapter = shoppingListAdapter
            layoutManager = LinearLayoutManager(context)
            itemTouchHelper.attachToRecyclerView(this)
        }
    }

    override fun addNewShoppingList() {
        findNavController().navigate(CurrentListFragmentDirections.actionAddShoppingList())
    }

    override fun delete(position: Int) {
        shopping_list_recycler_view.adapter?.notifyDataSetChanged()
        val shoppingItem = shoppingListAdapter.getAdapterItem(position)
        shoppingItem?.let {
//            currentListPresenter.deleteItem(it.shoppingItemId)
        showShortToast("Deleting: ${it.name}")
        }
    }

    override fun edit(position: Int) {
        val shoppingItem = shoppingListAdapter.getAdapterItem(position)
        shoppingItem?.let {
//            currentListPresenter.edit(it.shoppingItemId)
            showShortToast("Editing: ${it.name}")
        }
    }

}
