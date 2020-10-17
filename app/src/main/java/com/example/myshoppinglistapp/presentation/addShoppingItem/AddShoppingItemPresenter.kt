package com.example.myshoppinglistapp.presentation.addShoppingItem

import android.util.Log
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.data.repository.ShoppingItemRepository
import com.example.myshoppinglistapp.presentation.base.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import java.time.LocalDate
import javax.inject.Inject

class AddShoppingItemPresenter @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository,
    private val scheduler: SchedulerProvider,
    private val viewInterface: AddShoppingItemContract.AddViewInterface
):  BasePresenter<AddShoppingItemContract.AddViewInterface>(viewInterface),
    AddShoppingItemContract.AddPresenterInterface {

    override fun addShoppingItem(shoppingItemName: String) {
        val shoppingItem = ShoppingList(name = shoppingItemName, archived = false, date = LocalDate.now())
        shoppingItemRepository.add(shoppingItem)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(
                onComplete = {view.navigateToShoppingItems() },
                onError = { Log.e("ERROR_ADD_SHOPPING_ITEM", "Error adding shopping items", it)}
            ).addToDisposables()
    }
}