package ru.endlesscode.miet.orioks.util

fun <T> List<T>.chunkedBy(condition: (prev: T, current: T) -> Boolean): List<List<T>> {
    if (this.isEmpty()) return emptyList()

    val result = mutableListOf<List<T>>()
    var prev = this.first()
    var tmp = mutableListOf(prev)
    for (i in 1..this.lastIndex) {
        val current = this[i]

        if (!condition(prev, current)) {
            result.add(tmp)
            tmp = mutableListOf()
        }

        tmp.add(current)
        prev = current
    }

    result.add(tmp)
    return result
}
