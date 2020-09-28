package com.example.myshoppinglistapp.presentation.current.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import java.time.format.DateTimeFormatter

class ShoppingListAdapter(
    private val shoppingLists: List<ShoppingList>,
    private val listener : (ShoppingList) -> Unit
) :
    RecyclerView.Adapter<ShoppingRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingRecyclerViewHolder {
        val title = LayoutInflater.from(parent.context)
            .inflate(R.layout.shopping_list_item, parent, false)
        return ShoppingRecyclerViewHolder(title)
    }

    override fun getItemCount(): Int = shoppingLists.size

    fun getAdapterItem(position: Int) = shoppingLists.getOrNull(position)

    override fun onBindViewHolder(holder: ShoppingRecyclerViewHolder, position: Int) {
        val item = shoppingLists[position]
        (holder.itemView).findViewById<TextView>(R.id.name).text = item.name
        val dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        (holder.itemView).findViewById<TextView>(R.id.date).text = item.date.format(dateFormater)
        holder.itemView.setOnClickListener { listener(item)}
    }
}