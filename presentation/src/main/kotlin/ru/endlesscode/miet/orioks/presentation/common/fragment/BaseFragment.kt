package ru.endlesscode.miet.orioks.presentation.common.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment


abstract class BaseFragment : MvpAppCompatFragment() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    fun snackbar(
        view: View,
        @StringRes
        messageId: Int,
        duration: Int = Snackbar.LENGTH_LONG,
        @StringRes
        actionTextId: Int = 0,
        action: () -> Unit = {}
    ) {
        Snackbar.make(view, messageId, duration)
            .apply {
                if (actionTextId != 0) {
                    setAction(actionTextId) { action.invoke() }
                }
            }
            .show()
    }
}
