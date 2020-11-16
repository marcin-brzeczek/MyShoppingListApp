package com.example.myshoppinglistapp.presentation.archivedShoppingList

import android.util.Log
import com.example.myshoppinglistapp.data.model.ShoppingList
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.base.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import java.time.LocalDate
import javax.inject.Inject

class ArchivedShoppingListPresenter @Inject constructor(
    private val shoppingArchListRepository: ShoppingListRepository,
    private val schedulerArch: SchedulerProvider,
    private val viewInterfaceArch: ArchivedShoppingListContract.ArchivedViewInterface
) : BasePresenter<ArchivedShoppingListContract.ArchivedViewInterface>(viewInterfaceArch),
    ArchivedShoppingListContract.ArchivedPresenterInterface{

    override fun archiveAddShoppingList(shoppiongListName: String) {
        val archiveShoppingList = ShoppingList(name = shoppiongListName, archived = true, date = LocalDate.now())
        shoppingArchListRepository.add(archiveShoppingList)
            .subscribeOn(schedulerArch.io())
            .observeOn(schedulerArch.ui())
            .subscribeBy(
                onComplete = { view.navigateToShoppingLists() },
                onError = { Log.e("ERROR_ARC_SHOPPING_LIST", "Error fetching archive shopping lists") }
            ).addToDisposables()
}
    }
