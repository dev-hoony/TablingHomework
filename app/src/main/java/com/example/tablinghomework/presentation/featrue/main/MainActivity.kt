package com.example.tablinghomework.presentation.featrue.main

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.tablinghomework.R
import com.example.tablinghomework.databinding.ActivityMainBinding
import com.example.tablinghomework.presentation.featrue.like.LikeStoreFragment
import com.example.tablinghomework.presentation.util.base.ViewBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>() {

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            replaceSelectedFragment(
                containerFragment,
                containerFragment.id,
                LikeStoreFragment.getInstance(),
                ""
            )

            navigationView.selectedItemId = R.id.like_graph

            toolbarMain.title = getString(R.string.navigation_like)
            setSupportActionBar(toolbarMain)

        }
    }


    // Fragment Change
    private fun replaceSelectedFragment(
        layout: FrameLayout,
        layoutId: Int,
        fragment: Fragment?,
        tag: String
    ) {

        layout.removeAllViewsInLayout()
        supportFragmentManager.beginTransaction()
            .replace(layoutId, fragment!!)
            .disallowAddToBackStack()
            .commit()

        layout.requestFocus()
    }
}