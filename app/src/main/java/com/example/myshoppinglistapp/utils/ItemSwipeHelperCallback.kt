package com.example.myshoppinglistapp.utils

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface OnSwipeListener {
    fun delete(position: Int)
    fun edit(position: Int)
}

class ItemSwipeHelperCallback(
    val onSwipeListener: OnSwipeListener
) : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.ACTION_STATE_IDLE,
    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        if (direction == ItemTouchHelper.LEFT) {
            onSwipeListener.delete(position)
        } else {
            onSwipeListener.edit(position)
        }
    }
}