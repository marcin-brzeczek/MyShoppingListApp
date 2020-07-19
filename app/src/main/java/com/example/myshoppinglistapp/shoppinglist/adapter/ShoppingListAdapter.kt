package com.example.myshoppinglistapp.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.shoppinglist.model.ShoppingList

class ShoppingListAdapter(private val shoppingLists: List<ShoppingList>) :
    RecyclerView.Adapter<ShoppingRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingRecyclerViewHolder {
        val title = LayoutInflater.from(parent.context)
            .inflate(R.layout.shopping_list_item, parent, false)
        return ShoppingRecyclerViewHolder(title)
    }

    override fun getItemCount(): Int = shoppingLists.size

    override fun onBindViewHolder(holder: ShoppingRecyclerViewHolder, position: Int) {
        (holder.itemView as TextView).text = shoppingLists[position].name
    }
}