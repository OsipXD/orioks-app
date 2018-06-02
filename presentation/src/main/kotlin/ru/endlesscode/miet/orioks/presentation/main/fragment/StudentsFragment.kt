package ru.endlesscode.miet.orioks.presentation.main.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.screen_students.*
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.presentation.common.fragment.BaseFragment
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class StudentsFragment : BaseFragment() {

    companion object {
        fun newInstance(): StudentsFragment = StudentsFragment()
    }

    override val layoutId = R.layout.screen_students

    @Inject
    internal lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.main.provideComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerListeners()
    }

    private fun registerListeners() {
        student1_button.setOnClickListener { goToNextScreen() }
    }

    private fun goToNextScreen() {
        router.navigateTo(Screens.MAIN_MENU)
    }
}
