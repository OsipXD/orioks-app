package ru.endlesscode.miet.orioks.model

data class Subject(
        val title: String,
        val department: String,
        val rank: Int,
        val teachers: List<String>,
        val type: SubjectForm,
        val onThisWeek: Boolean
)

enum class SubjectForm {
    EXAM, CREDIT, GRADED_CREDIT
}

