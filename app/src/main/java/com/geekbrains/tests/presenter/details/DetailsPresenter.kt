package com.geekbrains.tests.presenter.details

import android.view.View
import com.geekbrains.tests.view.details.ViewDetailsContract
import java.lang.ref.WeakReference

internal class DetailsPresenter internal constructor(
    private val viewContract: ViewDetailsContract,
    private var count: Int = 0
) : PresenterDetailsContract {

    private var viewRef: WeakReference<View>? = null

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract.setCount(count)
    }

    override fun onAttach(view: View) {
        viewRef = WeakReference(view)
    }

    override fun view(): View? = viewRef?.get()

    override fun onDetach() {
        viewRef?.clear()
        viewRef = null
    }

}
