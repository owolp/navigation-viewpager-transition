package com.github.owolp.navigationviewpagertransition

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_pager.*
import java.io.Serializable

class PagerFragment : Fragment() {

    interface ViewCreatedListener : Serializable {
        fun invoke()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pager, container, false)

        handleTransition()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initTabLayout()
    }

    private fun handleTransition() {
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        postponeEnterTransition()
    }

    private fun initAdapter() {
        fragmentManager?.let { fragmentManager ->
            val callback = object : ViewCreatedListener {
                override fun invoke() {
                    startPostponedEnterTransition()
                }
            }

            SampleFragmentPagerAdapter(context, fragmentManager, callback).also {
                view_pager.adapter = it
            }
        }
    }

    private fun initTabLayout() {
        tab_layout.setupWithViewPager(view_pager)
    }
}