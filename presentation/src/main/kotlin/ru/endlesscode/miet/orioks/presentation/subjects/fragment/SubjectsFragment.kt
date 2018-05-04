package ru.endlesscode.miet.orioks.presentation.subjects.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.screen_subject_list.*
import ru.endlesscode.github.util.makeGone
import ru.endlesscode.miet.orioks.DummyData
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.internal.di.DI
import ru.endlesscode.miet.orioks.model.entity.Subject
import ru.endlesscode.miet.orioks.model.entity.SubjectForm
import ru.endlesscode.miet.orioks.presentation.common.fragment.BaseFragment
import ru.endlesscode.miet.orioks.presentation.subjects.adapter.SubjectsAdapter

class SubjectsFragment : BaseFragment() {

    companion object {
        fun newInstance(): SubjectsFragment = SubjectsFragment()
    }

    override val layoutId = R.layout.screen_subject_list

    private val subjAdapter by lazy { SubjectsAdapter() }
    private val debtAdapter by lazy { SubjectsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.main.provideComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSubjects()
        initDebts()
    }

    private fun initSubjects() {
        subjects_list.init(subjAdapter)
        subjAdapter.initItems(DummyData.userSubjects)
    }

    private fun initDebts() {
        val debts = DummyData.userDebts
        if (debts.isEmpty()) {
            debts_title_text_view.makeGone()
            debts_list.makeGone()
            return
        }

        debts_list.init(debtAdapter)
        debtAdapter.initItems(debts)
    }

    private fun RecyclerView.init(adapter: SubjectsAdapter) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        if (this.adapter == null) this.adapter = adapter
    }
}
