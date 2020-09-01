package com.example.myshoppinglistapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "shoppingLists")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true)
    val shoppingListId: Long = 0,
    val name: String,
    val date: LocalDate,
    val archived: Boolean
)
