package com.example.myshoppinglistapp.presentation.addShoppingList

import android.util.Log
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class AddShoppingListPresenter @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository,
    private val scheduler: SchedulerProvider,
    private val viewInterface: AddShoppingListContract.AddViewInterface
) : BasePresenter<AddShoppingListContract.AddViewInterface>(viewInterface) , AddShoppingListContract.AddPresenterInterface {

        override fun addShoppingLists(shoppingListName: String) {
            shoppingListRepository.add()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribeBy(
                    onComplete = { finish() },
                    onError = { Log.e("ERROR_ADD_SHOPPING_LIST", "Error adding shopping lists", it) }
                ).addToDisposables()
        }
    }


