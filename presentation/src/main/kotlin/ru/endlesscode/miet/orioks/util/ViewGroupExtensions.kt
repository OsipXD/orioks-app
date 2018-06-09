package ru.endlesscode.miet.orioks.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager


@Suppress("UNCHECKED_CAST")
fun <T : View> ViewGroup.inflateChild(
    @LayoutRes
    layoutId: Int,
    attachToRoot: Boolean = false
): T = LayoutInflater.from(this.context).inflate(layoutId, this, attachToRoot) as T


fun ViewGroup.removeFocus() {
    val focused = this.focusedChild ?: return
    val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(focused.windowToken, 0)
}
