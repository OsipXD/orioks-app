package ru.endlesscode.miet.orioks.presentation.main.presenter

import ru.endlesscode.miet.orioks.internal.di.MainScope
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.presentation.common.presenter.BasePresenter
import ru.endlesscode.miet.orioks.presentation.main.view.MainView
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@MainScope
class MainPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<MainView>() {

    fun goToFirstScreen() {
        router.replaceScreen(Screens.STUDENTS)
    }
}
