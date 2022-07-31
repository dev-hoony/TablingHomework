package com.example.tablinghomework.presentation.mapper

import com.example.tablinghomework.domain.model.StoreModel
import com.example.tablinghomework.presentation.featrue.like.StoreView
import javax.inject.Inject

class StoreViewMapper @Inject constructor() {

    fun transform(entity: StoreModel): StoreView = with(entity) {
        StoreView(
            id = id,
            thumbnail = thumbnail,
            category = category,
            name = name,
            ratingCount = rating.toString(),
            reviewCount = reviewCount,
            address = address,
            isNew = isNew,
            isWished = false,
            isNoWaiting = waitingCount == 0,
            isRemoteWaiting = isRemoteWaiting,
            isQuickBooking = isQuickBooking
        )
    }

}