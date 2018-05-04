package ru.endlesscode.miet.orioks.model.entity

import ru.endlesscode.miet.orioks.R

data class Subject(
        val title: String,
        val department: String,
        val rank: Int,
        val teachers: List<String>,
        val type: SubjectForm,
        val onThisWeek: Boolean
)

enum class SubjectForm {
    EXAM, CREDIT, GRADED_CREDIT;

    fun getTypeText(): Int {
        return when (this) {
            SubjectForm.EXAM -> R.string.form_exam
            SubjectForm.CREDIT -> R.string.form_credit
            SubjectForm.GRADED_CREDIT -> R.string.form_graded_credit
        }
    }
}

