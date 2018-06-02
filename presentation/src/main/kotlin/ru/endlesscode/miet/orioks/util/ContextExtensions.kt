package ru.endlesscode.miet.orioks.util

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

fun Context.getColorCompat(@ColorRes colorId: Int): Int {
    return ContextCompat.getColor(this, colorId)
}
