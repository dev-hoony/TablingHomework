package com.example.tablinghomework.domain.model

data class StoreModel(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val category: String,
    val rating: Double,
    val reviewCount: Int,
    val address: String,
    val isQuickBooking: Boolean, // 즉시 예약
    val isRemoteWaiting: Boolean, // 원격줄서기
    val useWaiting: Boolean, //
    val useBooking: Boolean, //
    val isNew: Boolean,
    val waitingCount: Int,
)

