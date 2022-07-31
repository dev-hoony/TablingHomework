package com.example.tablinghomework.data.datasource

import com.example.tablinghomework.data.entity.ListResponse
import com.example.tablinghomework.data.entity.StoreEntity
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoreService @Inject constructor(retrofit: Retrofit) : StoreApi {

    private val storeApi: StoreApi by lazy { retrofit.create(StoreApi::class.java) }

    override suspend fun getSavedStoreList(): Response<ListResponse<StoreEntity>> {
        return storeApi.getSavedStoreList()
    }

    override suspend fun getRecentStoreList(): Response<ListResponse<StoreEntity>> {
        return storeApi.getRecentStoreList()
    }

}