package ru.endlesscode.miet.orioks.presentation.main.presenter

import ru.endlesscode.miet.orioks.internal.di.MainScope
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.internal.di.Local
import ru.endlesscode.miet.orioks.presentation.common.presenter.BasePresenter
import ru.endlesscode.miet.orioks.presentation.main.view.MainMenuView
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@MainScope
class MainMenuPresenter @Inject constructor(@Local private val cicerone: Cicerone<Router>) : BasePresenter<MainMenuView>() {

    private val router get() = cicerone.router
    private val navigatorHolder get() = cicerone.navigatorHolder
    private var currentItem: Int = 0

    override fun attachView(view: MainMenuView) {
        super.attachView(view)

        if (currentItem != 0) {
            TODO()
        }
    }

    fun onNavItemSelected(itemId: Int) {
        val screen = when (itemId) {
            R.id.nav_news -> Screens.NEWS
            R.id.nav_learning -> Screens.PROGRESS
            R.id.nav_schedule -> Screens.SCHEDULE
            R.id.nav_faq -> Screens.FAQ
            R.id.nav_settings -> Screens.SETTINGS
            else -> error("Unknown navigation menu item!")
        }

        currentItem = itemId
        router.navigateTo(screen)
    }

    fun setNavigator(navigator: Navigator) {
        navigatorHolder.setNavigator(navigator)
    }

    fun removeNavigator() {
        navigatorHolder.removeNavigator()
    }
}
