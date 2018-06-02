package ru.endlesscode.miet.orioks.converter

import ru.endlesscode.miet.orioks.R
import ru.endlesscode.miet.orioks.model.SubjectForm

fun SubjectForm.getTypeText(): Int {
    return when (this) {
        SubjectForm.EXAM -> R.string.form_exam
        SubjectForm.CREDIT -> R.string.form_credit
        SubjectForm.GRADED_CREDIT -> R.string.form_graded_credit
        SubjectForm.DIPLOMA -> R.string.form_diploma
    }
}
