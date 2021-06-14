package com.geekbrains.tests.view.details

import android.view.View
import com.geekbrains.tests.view.ViewContract

internal interface ViewDetailsContract : ViewContract {
    fun attachView(view: View): View
    fun detachView(): View?
    fun setCount(count: Int)
}
