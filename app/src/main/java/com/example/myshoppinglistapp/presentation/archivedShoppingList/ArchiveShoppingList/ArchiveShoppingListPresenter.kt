package com.example.myshoppinglistapp.presentation.archivedShoppingList.ArchiveShoppingList

import android.util.Log
import com.example.myshoppinglistapp.data.repository.ShoppingListRepository
import com.example.myshoppinglistapp.presentation.BasePresenter
import com.example.myshoppinglistapp.utils.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ArchiveShoppingListPresenter @Inject constructor(
    private val archiveShoppingListRepository: ShoppingListRepository,
    private val archiveScheduler: SchedulerProvider,
    private val archiveViewInterface: ArchiveShoppingListContract.ArchViewInterface
) : BasePresenter<ArchiveShoppingListContract.ArchViewInterface>(archiveViewInterface) , ArchiveShoppingListContract.ArchivePresenterInterface {

    override fun getArchiveShoppingLists() {
        archiveShoppingListRepository.getAllOrderedByDate(archived = true)
            .subscribeOn(archiveScheduler.io())
            .observeOn(archiveScheduler.ui())
            .subscribeBy(
                onNext = { archiveViewInterface.displayArchiveShoppingLists(it) },
                onError = { Log.e("ERROR_ARC_SHOPPING_LIST", "Error fetching archive shopping lists", it) }
            ).addToDisposables()
    }

}