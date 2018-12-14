package com.github.owolp.navigationviewpagertransition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import kotlinx.android.synthetic.main.fragment_logo.*

class LogoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_logo, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLogoButton(view)
    }

    private fun initLogoButton(view: View) {
        logo.setOnClickListener {
            val action = LogoFragmentDirections.actionNavLogoToNavViewPager()

            val extras = FragmentNavigatorExtras(
                    logo to getString(R.string.logo_transition)
            )

            view.findNavController().navigate(action, extras)
        }
    }
}