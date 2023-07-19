package com.example.recharge

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.recharge.databinding.FirstBinding

class FirstAdapter(@LayoutRes layoutResId: Int, data: MutableList<Piggy>?) : BaseQuickAdapter<Piggy, BaseViewHolder>(layoutResId, data) {
    private var onItemClickListener: ((Piggy) -> Unit)? = null
    override fun convert(holder: BaseViewHolder, item: Piggy) {
        val binding = FirstBinding.bind(holder.itemView)
        binding.itemImage.setImageResource(item.image)
        binding.itemTitle.text = item.name
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)
        }
    }
    fun setOnItemClickListener(listener: (Piggy) -> Unit) {
        onItemClickListener = listener
    }
}