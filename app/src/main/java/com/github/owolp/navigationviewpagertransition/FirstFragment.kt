package com.github.owolp.navigationviewpagertransition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    companion object {

        private const val CALLBACK_FUNC = "callback"

        fun newInstance(
                callback: PagerFragment.ViewCreatedListener
        ): FirstFragment {
            return FirstFragment().apply {
                arguments = bundleOf(
                        CALLBACK_FUNC to callback
                )
            }
        }
    }

    private lateinit var callback: PagerFragment.ViewCreatedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getSerializable(CALLBACK_FUNC)?.let {
            callback = it as PagerFragment.ViewCreatedListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        callback.invoke()

        return view
    }
}