package ru.endlesscode.miet.orioks.util

internal class ValidationRule(
        val code: Int,
        val validate: (CharSequence) -> Boolean
)
