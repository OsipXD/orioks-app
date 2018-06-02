package ru.endlesscode.miet.orioks

import ru.endlesscode.miet.orioks.model.Subject
import ru.endlesscode.miet.orioks.model.SubjectForm
import ru.endlesscode.miet.orioks.model.User

object DummyData {

    val users = arrayOf(
            User("Осип Фаткуллин", "8140868", "МП-45"),
            User("Александр Самойленко", "81408658", "МП-45")
    )

    val user get() = users[selectedUser]
    val userSubjects get() = usersSubjects[selectedUser]
    val userDebts get() = usersDebts[selectedUser]
    lateinit var subject: Subject

    private val usersSubjects = arrayOf(
            listOf(
                    Subject("Государственная итоговая аттестация", "Кафедра информатики и программного обеспечения вычислительных систем", -1, listOf("Федотова Елена Леонидовна"), SubjectForm.DIPLOMA, false),
                    Subject("Производственная практика (Преддипломная практика)", "Кафедра информатики и программного обеспечения вычислительных систем", -1, listOf("Федотова Елена Леонидовна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Производственная практика (Практика по получению профессиональных умений и опыта профессиональной деятельности)", "Кафедра информатики и программного обеспечения вычислительных систем", 86, listOf("Федотова Елена Леонидовна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Учебная практика (Практика по получению первичных профессиональных умений и навыков)", "Кафедра информатики и программного обеспечения вычислительных систем", 100, listOf("Федотова Елена Леонидовна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Управление программными проектами", "Кафедра информатики и программного обеспечения вычислительных систем", 50, listOf("Слюсарь Валентин Викторович"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Нейронные сети", "Кафедра информатики и программного обеспечения вычислительных систем", 56, listOf("Рычагов Михаил Николаевич"), SubjectForm.GRADED_CREDIT, false)
            ),
            listOf(
                    Subject("Государственная итоговая аттестация", "Кафедра информатики и программного обеспечения вычислительных систем", -1, listOf("Кононова Александра Игоревна"), SubjectForm.DIPLOMA, false),
                    Subject("Производственная практика (Преддипломная практика)", "Кафедра информатики и программного обеспечения вычислительных систем", -1, listOf("Кононова Александра Игоревна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Производственная практика (Практика по получению профессиональных умений и опыта профессиональной деятельности)", "Кафедра информатики и программного обеспечения вычислительных систем", 77, listOf("Кононова Александра Игоревна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Учебная практика (Практика по получению первичных профессиональных умений и навыков)", "Кафедра информатики и программного обеспечения вычислительных систем", 75, listOf("Кононова Александра Игоревна"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Управление программными проектами", "Кафедра информатики и программного обеспечения вычислительных систем", 52, listOf("Слюсарь Валентин Викторович"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Нейронные сети", "Кафедра информатики и программного обеспечения вычислительных систем", 60, listOf("Рычагов Михаил Николаевич"), SubjectForm.GRADED_CREDIT, false)
            )
    )

    private val usersDebts = arrayOf(
            listOf<Subject>(),
            listOf()
    )

    private var selectedUser = -1

    fun select(id: Int) {
        selectedUser = id.coerceIn(0 until users.size)
    }

    fun selectSubject(subject: Subject) {
        this.subject = subject
    }
}
