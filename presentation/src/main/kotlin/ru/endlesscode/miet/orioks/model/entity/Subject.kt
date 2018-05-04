package ru.endlesscode.miet.orioks.model.entity

import ru.endlesscode.miet.orioks.presentation.subjects.fragment.SubjectsFragment

data class Subject(
        val title: String,
        val department: String,
        val rank: Int,
        val teacher: String,
        val type: SubjectForm,
        val onThisWeek: Boolean
)

enum class SubjectForm {
    EXAM, CREDIT, GRADED_CREDIT
}

