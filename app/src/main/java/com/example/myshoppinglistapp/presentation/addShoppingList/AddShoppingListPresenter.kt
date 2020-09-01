package com.example.myshoppinglistapp.presentation.addShoppingList

import android.util.Log
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import java.time.LocalDate
import javax.inject.Inject

class AddShoppingListPresenter @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository,
    private val scheduler: SchedulerProvider,
    private val viewInterface: AddShoppingListContract.AddViewInterface
) : BasePresenter<AddShoppingListContract.AddViewInterface>(viewInterface),
    AddShoppingListContract.AddPresenterInterface {

    override fun addShoppingList(shoppingListName: String) {
        val shoppingList = ShoppingList(name = shoppingListName, archived = false, date = LocalDate.now())
        shoppingListRepository.add(shoppingList)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(
                onComplete = { view.navigateToShoppingLists() },
                onError = { Log.e("ERROR_ADD_SHOPPING_LIST", "Error adding shoppidang lists", it) }
            ).addToDisposables()
    }
}


