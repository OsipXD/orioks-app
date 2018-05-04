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

    private val usersSubjects = arrayOf(
            listOf(
                    Subject("Управление программными проектами", "Кафедра ИПОВС", 63, "Слюсарь Валентин Викторович", SubjectForm.GRADED_CREDIT, false),
                    Subject("Программная инженерия управляющих систем", "Кафедра ИПОВС", 39, "Трояновский Владимир Михайлович", SubjectForm.CREDIT, false),
                    Subject("Нейронные сети", "Кафедра ИПОВС", 15, "Рычагов Михаил Николаевич", SubjectForm.EXAM, true),
                    Subject("Технология программирования Message Passing Interface", "Кафедра ИПОВС", 57, "Янакова Елена Сергеевна", SubjectForm.GRADED_CREDIT, true)
            ),
            listOf(
                    Subject("Управление программными проектами", "Кафедра ИПОВС", 83, "Слюсарь Валентин Викторович", SubjectForm.GRADED_CREDIT, false),
                    Subject("Программная инженерия управляющих систем", "Кафедра ИПОВС", 75, "Трояновский Владимир Михайлович", SubjectForm.CREDIT, false),
                    Subject("Нейронные сети", "Кафедра ИПОВС", 85, "Рычагов Михаил Николаевич", SubjectForm.EXAM, true),
                    Subject("Технология программирования OpenMP", "Кафедра ИПОВС", 95, "Янакова Елена Сергеевна", SubjectForm.GRADED_CREDIT, true)
            )
    )

    private val usersDebts = arrayOf(
            listOf(
                    Subject("Математическая логика и теория алгоритмов", "Кафедра ВМ-1", 32, "Кожухов Игорь Борисович", SubjectForm.EXAM, true),
                    Subject("СУБД Oracle", "Кафедра ИПОВС", 53, "Илюшечкин Владимир Михайлович", SubjectForm.EXAM, true)
            ),
            listOf()
    )

    private var selectedUser = -1

    fun select(id: Int) {
        selectedUser = id.coerceIn(0 until users.size)
    }
}
