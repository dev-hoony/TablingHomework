package com.example.tablinghomework.presentation.featrue.like

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tablinghomework.domain.model.StoreModel
import com.example.tablinghomework.domain.usecase.GetRecentStoreListUseCase
import com.example.tablinghomework.domain.usecase.GetSavedStoreListUseCase
import com.example.tablinghomework.domain.usecase.base.UseCase
import com.example.tablinghomework.domain.usecase.base.UseCase.*
import com.example.tablinghomework.presentation.mapper.StoreViewMapper
import com.example.tablinghomework.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
    private val getSavedStoreListUseCase: GetSavedStoreListUseCase,
    private val getRecentStoreListUseCase: GetRecentStoreListUseCase,
    private val mapper: StoreViewMapper,
) : BaseViewModel() {

    private val _savedStoreListData: MutableLiveData<List<StoreView>> = MutableLiveData()
    val savedStoreListData: LiveData<List<StoreView>> = _savedStoreListData

    fun loadSavedStoreList() {

        getSavedStoreListUseCase(None(), viewModelScope) {
            it.fold(
                ::handleFailure,
                ::handleSavedStoreListSuccess
            )
        }

    }


    private fun handleSavedStoreListSuccess(list: List<StoreModel>) {
        _savedStoreListData.value = list.map {
            mapper.transform(it)
        }
    }


    private val _recentStoreListData: MutableLiveData<List<StoreView>> = MutableLiveData()
    val recentStoreListData: LiveData<List<StoreView>> = _recentStoreListData

    fun loadRecentStoreList() {

        getRecentStoreListUseCase(None(), viewModelScope) {
            it.fold(
                ::handleFailure,
                ::handleRecentStoreListSuccess
            )
        }

    }


    private fun handleRecentStoreListSuccess(list: List<StoreModel>) {
        _recentStoreListData.value = list.map {
            mapper.transform(it)
        }
    }



}