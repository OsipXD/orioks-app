package ru.endlesscode.miet.orioks

import ru.endlesscode.miet.orioks.model.entity.Subject
import ru.endlesscode.miet.orioks.model.entity.SubjectForm
import ru.endlesscode.miet.orioks.model.entity.User

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
                    Subject("Управление программными проектами", "Кафедра информатики и программного обеспечения вычислительных систем", 63, listOf("Слюсарь Валентин Викторович"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Программная инженерия управляющих систем", "Кафедра информатики и программного обеспечения вычислительных систем", 39, listOf("Трояновский Владимир Михайлович"), SubjectForm.CREDIT, false),
                    Subject("Нейронные сети", "Кафедра информатики и программного обеспечения вычислительных систем", 15, listOf("Рычагов Михаил Николаевич"), SubjectForm.EXAM, true),
                    Subject("Технология программирования Message Passing Interface", "Кафедра информатики и программного обеспечения вычислительных систем", 57, listOf("Янакова Елена Сергеевна"), SubjectForm.GRADED_CREDIT, true)
            ),
            listOf(
                    Subject("Управление программными проектами", "Кафедра информатики и программного обеспечения вычислительных систем", 83, listOf("Слюсарь Валентин Викторович"), SubjectForm.GRADED_CREDIT, false),
                    Subject("Программная инженерия управляющих систем", "Кафедра информатики и программного обеспечения вычислительных систем", 75, listOf("Трояновский Владимир Михайлович"), SubjectForm.CREDIT, false),
                    Subject("Нейронные сети", "Кафедра информатики и программного обеспечения вычислительных систем", 85, listOf("Рычагов Михаил Николаевич"), SubjectForm.EXAM, true),
                    Subject("Технология программирования OpenMP", "Кафедра информатики и программного обеспечения вычислительных систем", 95, listOf("Янакова Елена Сергеевна"), SubjectForm.GRADED_CREDIT, true)
            )
    )

    private val usersDebts = arrayOf(
            listOf(
                    Subject("Математическая логика и теория алгоритмов", "Кафедра высшей математики №1", 32, listOf("Кожухов Игорь Борисович", "Романов Алексей Васильевич"), SubjectForm.EXAM, true),
                    Subject("СУБД Oracle", "Кафедра информатики и программного обеспечения вычислительных систем", 53, listOf("Илюшечкин Владимир Михайлович"), SubjectForm.EXAM, true)
            ),
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
