package ru.endlesscode.miet.orioks.model

data class Subject(
        val title: String,
        val department: String,
        val teachers: List<String>,
        val type: SubjectForm,
        val onThisWeek: Boolean,
        val tests: List<Test>
) {
    val rank get() = tests.map { it.rank }.sum()
}

enum class SubjectForm {
    EXAM, CREDIT, GRADED_CREDIT, DIPLOMA
}

