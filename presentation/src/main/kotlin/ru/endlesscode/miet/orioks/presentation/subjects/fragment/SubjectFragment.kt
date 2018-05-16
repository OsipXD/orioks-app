package ru.endlesscode.miet.orioks.presentation.subjects.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import kotlinx.android.synthetic.main.screen_subject.*
import ru.endlesscode.miet.orioks.DummyData
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.presentation.common.fragment.BaseFragment
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SubjectFragment : BaseFragment() {

    companion object {
        fun newInstance(): SubjectFragment = SubjectFragment()
    }

    override val layoutId = R.layout.screen_subject

    @Inject
    internal lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.main.provideComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerListeners()
        initViews()
    }

    private fun registerListeners() {
        toolbar.setNavigationOnClickListener { router.exit() }
    }

    private fun initViews() {
        with(DummyData.subject) {
            subject_title_text_view.text = title
            subject_title_text_view.movementMethod = ScrollingMovementMethod()
            type_text_view.setText(type.getTypeText())
            teachers_text_view.text = teachers.joinToString("\n")
            department_text_view.text = department
        }
    }
}
