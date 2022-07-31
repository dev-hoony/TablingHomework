package com.example.tablinghomework.data.datasource

import com.example.tablinghomework.data.entity.ListResponse
import com.example.tablinghomework.data.entity.StoreEntity
import retrofit2.Response
import retrofit2.http.GET

interface StoreApi {

    @GET("tabling/tabling_mobile_test/save")
    suspend fun getSavedStoreList(): Response<ListResponse<StoreEntity>>

    @GET("tabling/tabling_mobile_test/recent")
    suspend fun getRecentStoreList(): Response<ListResponse<StoreEntity>>

}