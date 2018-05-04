package ru.endlesscode.miet.orioks.presentation.subjects.adapter

import android.content.res.ColorStateList
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_subject.view.*
import ru.endlesscode.github.util.handleVisibility
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.model.entity.Subject
import ru.endlesscode.miet.orioks.model.entity.SubjectForm
import ru.endlesscode.miet.orioks.presentation.common.adapter.ItemListAdapter

class SubjectsAdapter : ItemListAdapter<Subject>() {

    companion object {
        private val gradeColors = arrayOf(
                R.color.grade_red,
                R.color.grade_orange,
                R.color.grade_amber,
                R.color.grade_lime,
                R.color.grade_green
        )
    }

    override fun createItemViewHolder(group: ViewGroup): ItemViewHolder = ViewHolder(group)

    override fun initItemViewHolder(holder: ItemViewHolder, item: Subject) {
        if (holder !is ViewHolder) return
        holder.init(item)
    }

    private inner class ViewHolder(
            parent: ViewGroup
    ) : ItemListAdapter.ItemViewHolder(parent, R.layout.item_subject) {

        private lateinit var subject: Subject

        fun init(item: Subject) {
            this.subject = item

            itemView.init()
        }

        private fun View.init() {
            with(subject) {
                rank_text_view.text = rank.toString()
                week_indicator_image_view.handleVisibility(subject.onThisWeek)
                subject_text_view.text = title
                type_text_view.setText(getTypeText(type))

                val colorId = subject.rank / 20
                val color = ContextCompat.getColor(context, gradeColors[colorId])
                ViewCompat.setBackgroundTintList(rank_text_view, ColorStateList.valueOf(color))
            }
        }

        private fun getTypeText(type: SubjectForm): Int {
            return when (type) {
                SubjectForm.EXAM -> R.string.form_exam
                SubjectForm.CREDIT -> R.string.form_credit
                SubjectForm.GRADED_CREDIT -> R.string.form_graded_credit
            }
        }

    }
}
