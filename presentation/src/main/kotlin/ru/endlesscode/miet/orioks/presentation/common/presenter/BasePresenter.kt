package ru.endlesscode.miet.orioks.presentation.common.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class BasePresenter<T> : MvpPresenter<T>() where T : MvpView {

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    protected fun safeSubscribe(action: () -> Disposable) {
        compositeDisposable.add(action())
    }
}
