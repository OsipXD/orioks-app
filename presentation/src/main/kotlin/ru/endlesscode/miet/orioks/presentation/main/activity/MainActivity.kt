package ru.endlesscode.miet.orioks.presentation.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.presentation.common.activity.BaseActivity
import ru.endlesscode.miet.orioks.presentation.common.fragment.PlaceholderFragment
import ru.endlesscode.miet.orioks.presentation.main.fragment.MainMenuFragment
import ru.endlesscode.miet.orioks.presentation.main.fragment.StudentsFragment
import ru.endlesscode.miet.orioks.presentation.main.presenter.MainPresenter
import ru.endlesscode.miet.orioks.presentation.main.view.MainView
import ru.endlesscode.miet.orioks.presentation.subjects.fragment.SubjectFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    override val navigator: Navigator by lazy { LocalNavigator() }

    @Inject
    @InjectPresenter
    internal lateinit var presenter: MainPresenter

    @ProvidePresenter
    internal fun injectPresenter(): MainPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.main.provideComponent().inject(this)
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            presenter.goToFirstScreen()
        }
    }

    private inner class LocalNavigator : SupportAppNavigator(this, containerId) {

        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

        override fun createFragment(screenKey: String, data: Any?): Fragment? {
            return when (screenKey) {
                Screens.MAIN_MENU -> MainMenuFragment.newInstance()
                Screens.STUDENTS -> StudentsFragment.newInstance()
                Screens.SUBJECT -> SubjectFragment.newInstance()
                else -> PlaceholderFragment.newInstance(screenKey)
            }
        }
    }
}
