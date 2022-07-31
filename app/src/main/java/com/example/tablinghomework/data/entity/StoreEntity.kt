package com.example.tablinghomework.data.entity

data class StoreEntity(
    val restaurantIdx: Int,
    val thumbnail: String,
    val classification: String,
    val restaurantName: String,
    val rating: Double,
    val reviewCount: Int,
    val summaryAddress: String,
    val isQuickBooking: Boolean,
    val isRemoteWaiting: Boolean,
    val useWaiting: Boolean,
    val useBooking: Boolean,
    val isNew: Boolean,
    val waitingCount: Int,
) {
    companion object {
        fun empty() = StoreEntity(
            0, "", "", "", 0.0, 0,
            "",
            isQuickBooking = false,
            isRemoteWaiting = false,
            useWaiting = false,
            useBooking = false,
            isNew = false,
            waitingCount = 0
        )
    }
}
