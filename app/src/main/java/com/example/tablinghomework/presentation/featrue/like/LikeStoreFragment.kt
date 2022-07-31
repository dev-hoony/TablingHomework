package com.example.tablinghomework.presentation.featrue.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablinghomework.databinding.FragmentLikeStoreBinding
import com.example.tablinghomework.presentation.util.base.ViewBindingFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeStoreFragment : ViewBindingFragment<FragmentLikeStoreBinding>() {

    companion object {
        fun getInstance() = LikeStoreFragment()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLikeStoreBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabArr = arrayOf("저장", "최근본", "찜")

        with(binding) {
            viewPager.adapter = StoreViewPagerAdapter(this@LikeStoreFragment)

            TabLayoutMediator(layoutStoreTab, viewPager) { tab, position ->
                tab.text = tabArr[position]
            }.attach()
        }

    }

}