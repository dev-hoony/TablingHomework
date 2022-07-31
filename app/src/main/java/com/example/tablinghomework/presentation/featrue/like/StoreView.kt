package com.example.tablinghomework.presentation.featrue.like

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreView(
    val id: Int = 0,
    val thumbnail: String = "",
    val category: String = "",
    val name: String = "",
    val ratingCount: String = "",
    val reviewCount: Int = 0,
    val address: String = "",
    val isNew: Boolean = false,
    var isWished: Boolean = false, // 찜 저장 여부
    var isNoWaiting: Boolean = false, // 대기 없음
    var isRemoteWaiting: Boolean = false, // 원격줄서기
    var isQuickBooking: Boolean = false, // 즉시 예약
) : Parcelable
