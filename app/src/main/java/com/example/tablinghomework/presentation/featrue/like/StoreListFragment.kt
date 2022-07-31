package com.example.tablinghomework.presentation.featrue.like

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tablinghomework.R
import com.example.tablinghomework.databinding.FragmentStoreListBinding
import com.example.tablinghomework.di.AndroidApplication.Companion.ARG_OBJECT
import com.example.tablinghomework.presentation.util.base.ViewBindingFragment
import com.example.tablinghomework.presentation.util.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class StoreListFragment : ViewBindingFragment<FragmentStoreListBinding>() {

    @Inject
    lateinit var navigator: Navigator
    private val viewModel: StoreListViewModel by activityViewModels()

    private var fragmentIndex: Int = -1
    private val SAVED = 1
    private val RECENT = 2
    private val WISH = 3

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentStoreListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            fragmentIndex = getInt(ARG_OBJECT) // 1..3
            Log.e("StoreListFragment", "${getInt(ARG_OBJECT)}")

            initObserver()
            loadPage(getInt(ARG_OBJECT))
        }
    }

    private fun loadPage(position: Int) {
        when (position) {
            1 -> {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.loadSavedStoreList()
                }
            }
            2 -> CoroutineScope(Dispatchers.IO).launch {
                viewModel.loadRecentStoreList()
            }
            3 -> initView(
                listOf(
                    StoreView(category = "31"),
                    StoreView(category = "2"),
                    StoreView(category = "3"),
                    StoreView(category = "4"),
                )
            )
        }
    }

    private fun initView(list: List<StoreView>) = with(binding) {
        rvStore.adapter = StoreRecyclerViewAdapter(list).apply {
            itemClickListener = {
                navigator.moveStoreDetail(requireContext(), it)
            }
            wishButtonClickListener = {
                Toast.makeText(requireContext(), "wish click ${it.name}", Toast.LENGTH_SHORT).show()
            }
        }
        rvStore.layoutManager = LinearLayoutManager(requireContext()).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
    }

    private fun initObserver() {
        viewModel.savedStoreListData.observe(viewLifecycleOwner) {
            if (fragmentIndex == SAVED) initView(it)
        }

        viewModel.recentStoreListData.observe(viewLifecycleOwner) {
            if (fragmentIndex == RECENT) initView(it)
        }
    }


}