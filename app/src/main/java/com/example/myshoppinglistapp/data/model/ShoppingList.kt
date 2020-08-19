package com.example.myshoppinglistapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "shoppingLists")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true)
    val shoppingListId: Long = 0,
    val name: String,
    val date: Date,
    val archived: Boolean

)
