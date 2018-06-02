package ru.endlesscode.miet.orioks.util

import android.view.View


fun View.handleVisibility(visible: Boolean, gone: Boolean = true) {
    when {
        visible -> show()
        gone -> makeGone()
        else -> hide()
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}
