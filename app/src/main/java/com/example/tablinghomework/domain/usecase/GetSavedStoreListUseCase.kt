package com.example.tablinghomework.domain.usecase

import com.example.tablinghomework.domain.model.StoreModel
import com.example.tablinghomework.domain.repository.StoreRepository
import com.example.tablinghomework.domain.usecase.base.UseCase
import com.example.tablinghomework.domain.util.exception.Failure
import com.example.tablinghomework.domain.util.functional.Either
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetSavedStoreListUseCase
@Inject constructor(
    private val repository: StoreRepository
) : UseCase<List<StoreModel>, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, List<StoreModel>> =
        repository.getSavedStoreList()
}