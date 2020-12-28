package com.ddona.newspaperapplication.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ddona.newspaperapplication.ui.genk.ListFragment

class GenkAdapter : FragmentPagerAdapter {
    constructor(fm: FragmentManager) : super(
        fm,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )

    override fun getItem(position: Int): Fragment {
        val b = Bundle()
        when (position) {
            0 -> {
                b.putString("LINK", "https://genk.vn/mobile.chn")
            }
            1 -> {
                b.putString("LINK", "https://genk.vn/tin-ict.chn")
            }
            2 -> {
                b.putString("LINK", "https://genk.vn/internet.chn")
            }
            else ->{
                b.putString("LINK", "https://genk.vn/kham-pha.chn")
            }
        }

        val f = ListFragment()
        f.arguments = b
        return f
    }

    override fun getCount() = 4

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Mobile"
            }
            1 -> {
                return "Tin ICT"
            }
            2 -> {
                return "Internet"
            }
            else -> {
                return "Khám phá"
            }
        }
    }
}