package com.example.tablinghomework.data.repositoryimpl

import com.example.tablinghomework.data.datasource.StoreService
import com.example.tablinghomework.data.entity.ListResponse
import com.example.tablinghomework.data.mapper.StoreMapper
import com.example.tablinghomework.data.util.NetworkHandler
import com.example.tablinghomework.domain.model.StoreModel
import com.example.tablinghomework.domain.repository.StoreRepository
import com.example.tablinghomework.domain.util.exception.Failure
import com.example.tablinghomework.domain.util.exception.Failure.NetworkConnection
import com.example.tablinghomework.domain.util.exception.Failure.ServerError
import com.example.tablinghomework.domain.util.functional.Either
import com.example.tablinghomework.domain.util.functional.Either.Left
import com.example.tablinghomework.domain.util.functional.Either.Right
import retrofit2.Response
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val storeService: StoreService,
    private val mapper: StoreMapper,
    private val networkHandler: NetworkHandler,
) : StoreRepository {

    fun <T, R> request(
        response: Response<ListResponse<T>>,
        transform: (T) -> R,
        default: List<T>
    ): Either<Failure, List<R>> {
        return try {
            when (response.isSuccessful) {
                true -> {
                    val list = response.body()?.list ?: default as List<T>
                    Right(list.map { transform(it) })
                }
                false -> Left(ServerError)
            }
        } catch (exception: Throwable) {
            Left(ServerError)
        }
    }

    override suspend fun getSavedStoreList(): Either<Failure, List<StoreModel>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                storeService.getSavedStoreList(),
//                { mapper::transform(it) },
//                { mapper.transform(it)},
                mapper::transform,
                emptyList()
            )
            false -> Left(NetworkConnection)
        }
    }

    override suspend fun getRecentStoreList(): Either<Failure, List<StoreModel>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                storeService.getRecentStoreList(),
//                { it.map(mapper::transform) },
                mapper::transform,
                emptyList()
            )
            false -> Left(NetworkConnection)
        }
    }

//    override fun getStoreWishList(): Either<Failure, List<StoreModel>> {
//        TODO("Not yet implemented")
//    }
//
//    override fun saveStoreToWishList(): Either<Failure, StoreModel> {
//        TODO("Not yet implemented")
//    }
}