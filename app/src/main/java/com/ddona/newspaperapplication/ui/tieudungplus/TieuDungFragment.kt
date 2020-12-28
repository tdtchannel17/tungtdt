package com.ddona.newspaperapplication.ui.tieudungplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ddona.newspaperapplication.R
import com.ddona.newspaperapplication.adapter.GenkAdapter
import com.ddona.newspaperapplication.adapter.TieuDungAdapter
import com.ddona.newspaperapplication.databinding.FragmentPagerBinding

class TieuDungFragment : Fragment() {
    private lateinit var binding: FragmentPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        binding.tab.setupWithViewPager(
            binding.vp
        )
        binding.vp.adapter = TieuDungAdapter(childFragmentManager)
        return binding.root
    }

    fun openDetailTieuDungPlus(link: String){
        val amount = link
        val bundle = bundleOf("data" to amount)
        findNavController().navigate(R.id.nav_tieudungplus_to_detail, bundle)
    }
}