package ru.endlesscode.miet.orioks.util

import android.content.res.ColorStateList
import android.support.v4.view.ViewCompat
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

//
// Compat
//

var View.backgroundTintListCompat: ColorStateList
    set(value) = ViewCompat.setBackgroundTintList(this, value)
    get() = ViewCompat.getBackgroundTintList(this)
