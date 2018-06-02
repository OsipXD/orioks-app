package ru.endlesscode.miet.orioks.presentation.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.layout_navigation_header.view.*
import kotlinx.android.synthetic.main.screen_main_menu.*
import ru.endlesscode.miet.orioks.DummyData
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.presentation.common.fragment.BaseFragment
import ru.endlesscode.miet.orioks.presentation.common.fragment.PlaceholderFragment
import ru.endlesscode.miet.orioks.presentation.main.presenter.MainMenuPresenter
import ru.endlesscode.miet.orioks.presentation.main.view.MainMenuView
import ru.endlesscode.miet.orioks.presentation.subjects.fragment.SubjectsFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import javax.inject.Inject

class MainMenuFragment : BaseFragment(), MainMenuView {

    companion object {
        fun newInstance(): MainMenuFragment = MainMenuFragment()
    }

    override val layoutId = R.layout.screen_main_menu
    override val containerId = R.id.main_content

    @Inject
    @InjectPresenter
    internal lateinit var presenter: MainMenuPresenter

    private val navigator: Navigator by lazy { LocalNavigator() }

    private var canGoBack = false

    @ProvidePresenter
    internal fun providePresenter(): MainMenuPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.main.provideComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerListeners()
        initNavigation()
        initStudentInfo()
    }

    override fun onResume() {
        super.onResume()
        presenter.afterResume(navigator)
    }

    override fun onPause() {
        presenter.beforePause()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        return onBackToCloseDrawer() || super.onBackPressed()
    }

    private fun registerListeners() {
        nav_view.setNavigationItemSelectedListener { menuItem ->
            if (!menuItem.isChecked) {
                canGoBack = true
                presenter.onNavItemSelected(menuItem.itemId)
            }

            menuItem.isChecked = true
            drawer_layout.closeDrawers()

            true
        }
    }

    private fun initNavigation() {
        ActionBarDrawerToggle(
                activity,
                drawer_layout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ).apply {
            drawer_layout.addDrawerListener(this)
            syncState()
        }

        nav_view.menu.getItem(1).isChecked = true
        presenter.onNavItemSelected(R.id.nav_learning)
    }

    private fun initStudentInfo() {
        with(DummyData.user) {
            val view = nav_view.getHeaderView(0)
            view.name_text_view.text = name
            view.number_text_view.text = number
            view.group_text_view.text = group
        }
    }

    private fun onBackToCloseDrawer(): Boolean {
        if (drawer_layout.isDrawerOpen(Gravity.START)) {
            drawer_layout.closeDrawers()
            return true
        }

        return false
    }

    private inner class LocalNavigator : SupportFragmentNavigator(childFragmentManager, containerId) {

        override fun exit() {
            TODO()
        }

        override fun showSystemMessage(message: String?) {
            TODO()
        }

        override fun createFragment(screenKey: String, data: Any?): Fragment? {
            return when (screenKey) {
                Screens.PROGRESS -> SubjectsFragment.newInstance()
                Screens.NEWS -> PlaceholderFragment.newInstance("Новости")
                Screens.SETTINGS -> PlaceholderFragment.newInstance("Настройки")
                Screens.SCHEDULE -> PlaceholderFragment.newInstance("Расписание")
                Screens.FAQ -> PlaceholderFragment.newInstance("FAQ")
                else -> null
            }
        }
    }
}
