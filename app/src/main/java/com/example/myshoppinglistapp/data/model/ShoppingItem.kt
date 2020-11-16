package com.example.myshoppinglistapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "shoppingItems")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val shoppingItemId: Long.Companion,
    val shoppingListId: Long.Companion,
    val name: String,
    val date: LocalDate,
    val archived: Boolean = false
)