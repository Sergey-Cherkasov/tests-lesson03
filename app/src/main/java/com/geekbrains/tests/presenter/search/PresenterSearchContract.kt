package com.geekbrains.tests.presenter.search

import android.view.View
import com.geekbrains.tests.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
    fun view(): View?
    //onAttach
    //onDetach
}
