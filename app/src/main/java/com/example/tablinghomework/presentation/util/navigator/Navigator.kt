package com.example.tablinghomework.presentation.util.navigator

import android.content.Context
import com.example.tablinghomework.presentation.featrue.like.StoreDetailActivity
import com.example.tablinghomework.presentation.featrue.like.StoreView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun moveStoreDetail(context: Context, data: StoreView) =
        context.startActivity(StoreDetailActivity.callingIntent(context, data))

}