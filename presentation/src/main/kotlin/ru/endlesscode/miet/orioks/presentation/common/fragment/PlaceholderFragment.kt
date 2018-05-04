package ru.endlesscode.miet.orioks.presentation.common.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.screen_placeholder.*
import ru.endlesscode.miet.orioks.R


class PlaceholderFragment : BaseFragment() {

    companion object {
        private const val TITLE = "title"

        fun newInstance(title: String): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply { putString(TITLE, title) }
            }
        }
    }

    override val layoutId: Int = R.layout.screen_placeholder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val title = it.getString(TITLE)
            screen_title.text = getString(R.string.screen_placeholder_title, title)
        }
    }
}
