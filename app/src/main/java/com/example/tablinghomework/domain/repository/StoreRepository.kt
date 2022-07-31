package com.example.tablinghomework.domain.repository

import com.example.tablinghomework.domain.model.StoreModel
import com.example.tablinghomework.domain.util.exception.Failure
import com.example.tablinghomework.domain.util.functional.Either

interface StoreRepository {

    suspend fun getSavedStoreList(): Either<Failure, List<StoreModel>>
    suspend fun getRecentStoreList(): Either<Failure, List<StoreModel>>
//    fun getStoreWishList(): Either<Failure, List<StoreModel>>
//    fun saveStoreToWishList(): Either<Failure, StoreModel>

}