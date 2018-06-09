package ru.endlesscode.miet.orioks.presentation.subjects.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_test.view.*
import kotlinx.android.synthetic.main.item_test_week.view.*
import kotlinx.android.synthetic.main.layout_subject_data.*
import kotlinx.android.synthetic.main.screen_subject.*
import ru.endlesscode.miet.orioks.DummyData
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.converter.GradeConverter
import ru.endlesscode.miet.orioks.converter.getTypeText
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.model.Test
import ru.endlesscode.miet.orioks.presentation.common.fragment.BaseFragment
import ru.endlesscode.miet.orioks.util.chunkedBy
import ru.endlesscode.miet.orioks.util.getColorCompat
import ru.endlesscode.miet.orioks.util.inflateChild
import ru.endlesscode.miet.orioks.util.show
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

            tests.chunkedBy { prev, current -> prev.week == current.week }
                    .forEach { test_weeks_linear_layout.addTestWeek(it) }
        }
    }

    private fun LinearLayout.addTestWeek(tests: List<Test>) {
        val testWeekView = this.inflateChild<View>(R.layout.item_test_week)
        testWeekView.week_text_view.text = tests.first().week.toString()
        tests.forEach {
            testWeekView.tests_list_linear_layout.addTest(it)
        }

        this.addView(testWeekView)
    }

    private fun LinearLayout.addTest(test: Test) {
        val testView = this.inflateChild<View>(R.layout.item_test)
        with(testView) {
            type_text_view.text = test.type
            test.name?.let {
                name_text_view.text = it
                name_text_view.show()
            }

            rank_max_text_view.text = getString(R.string.test_max_rank, test.maxRank)

            if (test.rank < 0) {
                rank_current_text_view.text = "-"
                return@with
            }

            rank_current_text_view.text = test.rank.toString()
            val colorId = GradeConverter.rankToColor(test.rank, test.maxRank)
            val color = context.getColorCompat(colorId)
            rank_current_text_view.setTextColor(color)
        }

        this.addView(testView)
    }
}
