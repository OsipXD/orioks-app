package ru.endlesscode.miet.orioks.converter

import ru.endlesscode.miet.orioks.R

object GradeConverter {

    private val gradeZones = listOf(0.25, 0.5, 0.7, 0.85, 1.0)

    private val gradeColors = arrayOf(
            R.color.grade_red,
            R.color.grade_orange,
            R.color.grade_amber,
            R.color.grade_lime,
            R.color.grade_green
    )

    fun rankToColor(rank: Int, maxRank: Int = 100): Int {
        val colorId = gradeZones.indexOfFirst { rank <= maxRank * it }
        return gradeColors[colorId]
    }
}
