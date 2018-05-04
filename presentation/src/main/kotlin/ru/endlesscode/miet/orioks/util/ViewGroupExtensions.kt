package ru.endlesscode.github.util

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


@Suppress("UNCHECKED_CAST")
fun <T : View> ViewGroup.inflateChild(
    @LayoutRes
    layoutId: Int,
    attachToRoot: Boolean = false
): T = LayoutInflater.from(this.context).inflate(layoutId, this, attachToRoot) as T
