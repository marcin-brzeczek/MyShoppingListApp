package com.example.myshoppinglistapp.presentation.current

import android.util.Log
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.base.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CurrentListPresenter @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository,
    private val scheduler: SchedulerProvider,
    private val viewInterface: CurrentListContract.ViewInterface
) : BasePresenter<CurrentListContract.ViewInterface>(viewInterface) , CurrentListContract.PresenterInterface {

    override fun getShoppingLists() {
        shoppingListRepository.getAllOrderedByDate(archived = false)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(
                onNext = { viewInterface.displayShoppingLists(it) },
                onError = { Log.e("ERROR_GET_SHOPPING_LIST", "Error fetching shopping lists", it) }
            ).addToDisposables()
    }
}
