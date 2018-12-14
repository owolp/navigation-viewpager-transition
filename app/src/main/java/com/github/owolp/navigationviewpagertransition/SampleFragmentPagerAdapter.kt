package com.github.owolp.navigationviewpagertransition

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SampleFragmentPagerAdapter(
    private val context: Context?,
    fragmentManager: FragmentManager,
    callback: PagerFragment.ViewCreatedListener
) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragmentList = listOf(
        FirstFragment.newInstance(callback),
        SecondFragment(),
        ThirdFragment()
    )

    override fun getItem(position: Int): Fragment =
        fragmentList[position]

    override fun getCount(): Int =
        fragmentList.size

    override fun getPageTitle(position: Int): String? =
        context?.resources?.getStringArray(R.array.fragment_titles)?.get(position)
}