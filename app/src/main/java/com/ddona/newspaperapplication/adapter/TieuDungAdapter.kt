package com.ddona.newspaperapplication.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ddona.newspaperapplication.ui.tieudungplus.ListFragment

class TieuDungAdapter : FragmentPagerAdapter {
    constructor(fm: FragmentManager) : super(
        fm,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )

    override fun getItem(position: Int): Fragment {
        val b = Bundle()
        when (position) {
            0 -> {
                b.putString("LINK", "https://tieudungplus.vn/tieu-diem-c1.html")
            }
            1 -> {
                b.putString("LINK", "https://tieudungplus.vn/bao-ve-ntd-c2.html")
            }
            2 -> {
                b.putString("LINK", "https://tieudungplus.vn/bat-dong-san-c41.html")
            }
            3 -> {
                b.putString("LINK", "https://tieudungplus.vn/tai-chinh-ngan-hang-c6.html")
            }
            4 -> {
                b.putString("LINK", "https://tieudungplus.vn/thi-truong-c3.html")
            }
            5 -> {
                b.putString("LINK", "https://tieudungplus.vn/xe-cong-nghe-c81.html")
            }
            else ->{
                b.putString("LINK", "https://tieudungplus.vn/su-kien.html")
            }
        }

        val f = ListFragment()
        f.arguments = b
        return f
    }

    override fun getCount() = 6

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Đời sống"
            }
            1 -> {
                return "Bảo vệ NTD"
            }
            2 -> {
                return "Bất động sản"
            }
            3 -> {
                return "Tài chính 24h"
            }
            4 -> {
                return "Thị trường"
            }
            5 -> {
                return "Xe & Công nghệ"
            }
            else -> {
                return "Dòng sự kiện"
            }
        }
    }
}