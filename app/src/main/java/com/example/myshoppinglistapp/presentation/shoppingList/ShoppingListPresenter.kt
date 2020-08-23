package com.example.myshoppinglistapp.presentation.shoppingList

import android.util.Log
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ShoppingListPresenter @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository,
    private val scheduler: SchedulerProvider,
    private val viewInterface: ShoppingListContract.ViewInterface
) : BasePresenter<ShoppingListContract.ViewInterface>(viewInterface) , ShoppingListContract.PresenterInterface {

    override fun getShoppingLists() {
        shoppingListRepository.getAllOrderedByDate(archived = true)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(
                onNext = { viewInterface.displayShoppingLists(it) },
                onError = { Log.e("ERROR_GET_SHOPPING_LIST", "Erorr fetchinh shopping lists", it) }
            ).addToDisposables()
    }
}
