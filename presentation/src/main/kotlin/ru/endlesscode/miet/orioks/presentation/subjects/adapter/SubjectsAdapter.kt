package ru.endlesscode.miet.orioks.presentation.subjects.adapter

import android.content.res.ColorStateList
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_subject.view.*
import ru.endlesscode.miet.orioks.util.handleVisibility
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.converter.getTypeText
import ru.endlesscode.miet.orioks.model.Subject
import ru.endlesscode.miet.orioks.presentation.common.adapter.ItemListAdapter

class SubjectsAdapter : ItemListAdapter<Subject>() {

    companion object {
        private val gradeZones = listOf(25, 50, 70, 85, 100)

        private val gradeColors = arrayOf(
                R.color.grade_red,
                R.color.grade_orange,
                R.color.grade_amber,
                R.color.grade_lime,
                R.color.grade_green
        )
    }

    var onItemClickListener: (Subject) -> Unit = {}

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
            registerListeners()
        }

        private fun View.init() {
            with(subject) {
                week_indicator_image_view.handleVisibility(onThisWeek)
                subject_title_text_view.text = title
                type_text_view.setText(type.getTypeText())

                if (rank == -1) {
                    rank_text_view.text = "-"
                    val color = resources.getColor(R.color.white)
                    ViewCompat.setBackgroundTintList(rank_text_view, ColorStateList.valueOf(color))
                    return
                }

                rank_text_view.text = rank.toString()
                val colorId = gradeZones.indexOfFirst { rank <= it }
                val color = ContextCompat.getColor(context, gradeColors[colorId])
                ViewCompat.setBackgroundTintList(rank_text_view, ColorStateList.valueOf(color))
            }
        }

        private fun registerListeners() {
            itemView.setOnClickListener { onItemClickListener.invoke(subject) }
        }

    }
}
