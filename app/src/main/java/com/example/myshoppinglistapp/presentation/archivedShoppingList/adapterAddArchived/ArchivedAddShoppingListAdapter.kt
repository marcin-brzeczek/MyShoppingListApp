package com.example.myshoppinglistapp.presentation.archivedShoppingList.adapterAddArchived

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myshoppinglistapp.R
import com.example.myshoppinglistapp.data.model.ShoppingList
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class ArchivedAddShoppingListAdapter(
    private val archivedShoppingLists: List<ShoppingList>,
    private val archivedListener: (ShoppingList) -> Unit
):
        RecyclerView.Adapter<ArchivedAddShoppingListRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArchivedAddShoppingListRecyclerViewHolder {
        val archivedTitle = LayoutInflater.from((parent.context))
            .inflate(R.layout.shopping_list_item, parent,false)
        return ArchivedAddShoppingListRecyclerViewHolder(archivedTitle)
    }

    override fun getItemCount(): Int = archivedShoppingLists.size

    override fun onBindViewHolder(holder: ArchivedAddShoppingListRecyclerViewHolder, position: Int) {
        val archivedItem = archivedShoppingLists[position]
        (holder.itemView).findViewById<TextView>(R.id.name).text = archivedItem.name
        val dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        (holder.itemView).findViewById<TextView>(R.id.date).text = archivedItem.date.format(dateFormater)
        holder.itemView.setOnClickListener { archivedListener(archivedItem)}
    }
}
