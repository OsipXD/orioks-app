package ru.endlesscode.miet.orioks.presentation.common.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


open class BasePagerAdapter(
    fragmentManager: FragmentManager,
    initBlock: BasePagerAdapter.() -> Unit
) : FragmentPagerAdapter(fragmentManager) {

    private val fragmentTitles = mutableListOf<String>()
    private val fragmentList = mutableListOf<Fragment>()

    init {
        initBlock()
    }

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? = fragmentTitles[position]

    open fun fragment(title: String, fragment: Fragment) {
        fragmentTitles.add(title)
        fragmentList.add(fragment)
    }
}
