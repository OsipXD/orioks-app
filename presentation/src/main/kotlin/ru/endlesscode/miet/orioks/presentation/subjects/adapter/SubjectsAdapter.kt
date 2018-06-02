package ru.endlesscode.miet.orioks.presentation.subjects.adapter

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_subject.view.*
import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.converter.GradeConverter
import ru.endlesscode.miet.orioks.converter.getTypeText
import ru.endlesscode.miet.orioks.model.Subject
import ru.endlesscode.miet.orioks.presentation.common.adapter.ItemListAdapter
import ru.endlesscode.miet.orioks.util.backgroundTintListCompat
import ru.endlesscode.miet.orioks.util.getColorCompat
import ru.endlesscode.miet.orioks.util.handleVisibility

class SubjectsAdapter : ItemListAdapter<Subject>() {

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
                    return@with
                }

                rank_text_view.text = rank.toString()
                val colorId = GradeConverter.rankToColor(rank)
                val color = context.getColorCompat(colorId)
                rank_text_view.backgroundTintListCompat = ColorStateList.valueOf(color)
            }
        }

        private fun registerListeners() {
            itemView.setOnClickListener { onItemClickListener.invoke(subject) }
        }

    }
}
