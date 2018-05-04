package ru.endlesscode.miet.orioks.presentation.main.presenter

import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.presentation.common.presenter.BasePresenter
import ru.endlesscode.miet.orioks.presentation.main.view.MainMenuView
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class MainMenuPresenter @Inject constructor(private val router: Router) : BasePresenter<MainMenuView>() {

    fun onNavItemSelected(itemId: Int) {
        val screen = when (itemId) {
            R.id.nav_news -> Screens.NEWS
            R.id.nav_learning -> Screens.PROGRESS
            R.id.nav_schedule -> Screens.SCHEDULE
            R.id.nav_faq -> Screens.FAQ
            R.id.nav_settings -> Screens.SETTINGS
            else -> error("Unknown navigation menu item!")
        }

        router.navigateTo(screen)
    }
}
