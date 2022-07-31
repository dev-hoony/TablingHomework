package com.example.tablinghomework.presentation.featrue.like

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.tablinghomework.R
import com.example.tablinghomework.databinding.ActivityStoreDetailBinding
import com.example.tablinghomework.presentation.util.base.DataBindingActivity

class StoreDetailActivity : DataBindingActivity<ActivityStoreDetailBinding>() {

    companion object {
        fun callingIntent(context: Context, data: StoreView): Intent {
            val intent = Intent(context, StoreDetailActivity::class.java)
            intent.putExtra("data", data)
            return intent
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_store_detail

    override fun viewMaker(savedInstanceState: Bundle?) {

        val data = intent.getParcelableExtra<StoreView>("data")
        data?.let {
            binding.data = it
        }

    }
}