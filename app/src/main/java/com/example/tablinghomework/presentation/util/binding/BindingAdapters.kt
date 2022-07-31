package com.example.tablinghomework.presentation.util.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    /**
     * View의 visibility를 변경
     * @param view 속성을 사용하는 view
     * @param isVisible visibility를 변경시키는 기준이 되는 값
     */
    @JvmStatic
    @BindingAdapter("visible")
    fun setVisible(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("loadFromUrl")
    fun loadFromUrl(view: ImageView, url: String) {
        if (url.isNotEmpty()) {
            Glide.with(view.context).load(url).into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("wishStatus")
    fun setWishStatus(view: TextView, isLike: Boolean) {
        view.text = if (isLike) "찜 해제" else "찜하기"
    }

    @JvmStatic
    @BindingAdapter("reviewCount")
    fun setReviewCount(view: TextView, reviewCount: Int) {
        view.text = if (reviewCount > 300) "(300+)" else "($reviewCount)"
    }
}