package com.example.tablinghomework.presentation.featrue.like

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tablinghomework.R
import com.example.tablinghomework.databinding.ItemStoreBinding


class StoreRecyclerViewAdapter(private val list: List<StoreView>) :
    RecyclerView.Adapter<StoreRecyclerViewAdapter.ViewHolder>() {

    var itemClickListener: ((StoreView) -> Unit)? = null
    var wishButtonClickListener: ((StoreView) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_store,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: StoreView) {
            binding.data = data

            binding.root.setOnClickListener {
                itemClickListener?.invoke(data)
            }

            binding.tvWish.setOnClickListener {
                wishButtonClickListener?.invoke(data)
            }
        }
    }


}

