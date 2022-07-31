package com.example.tablinghomework.data.mapper

import com.example.tablinghomework.data.entity.StoreEntity
import com.example.tablinghomework.domain.model.StoreModel
import javax.inject.Inject

class StoreMapper @Inject constructor() {

    fun transform(entity: StoreEntity): StoreModel = with(entity) {
        StoreModel(
            id = restaurantIdx,
            name = restaurantName,
            thumbnail = thumbnail,
            category = classification,
            rating = rating,
            reviewCount = reviewCount,
            address = summaryAddress,
            isQuickBooking = isQuickBooking,
            isRemoteWaiting = isRemoteWaiting,
            useWaiting = useWaiting,
            useBooking = useBooking,
            isNew = isNew,
            waitingCount = waitingCount
        )
    }
}