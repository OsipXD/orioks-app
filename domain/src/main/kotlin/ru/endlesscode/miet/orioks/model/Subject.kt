package ru.endlesscode.miet.orioks.model

data class Subject(
        val title: String,
        val department: String,
        val teachers: List<String>,
        val type: SubjectForm,
        val onThisWeek: Boolean,
        val tests: List<Test>
) {
    val rank: Int
        get() = tests.map {
            if (it.rank == -1) return -1
            it.rank
        }.sum()
}

enum class SubjectForm {
    EXAM, CREDIT, GRADED_CREDIT, DIPLOMA
}

