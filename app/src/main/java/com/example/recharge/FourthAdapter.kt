package com.example.recharge

import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.recharge.databinding.FirstBinding
import com.example.recharge.databinding.FourthBinding

class FourthAdapter(@LayoutRes layoutResId: Int, data: MutableList<Card>?) : BaseQuickAdapter<Card, BaseViewHolder>(layoutResId, data) {

    private val SCALE = 4 * 1.0f / 3 //图片缩放比例

    override fun convert(holder: BaseViewHolder, item: Card) {
        val binding = FourthBinding.bind(holder.itemView)
        binding.ivImage.setImageResource(item.image)
        binding.name.text = item.name
        binding.name2.text = item.name2

        setCardView(holder, binding, item)
    }

    private fun setCardView(holder: BaseViewHolder, binding: FourthBinding, card: Card) {
        //计算图片宽高
        val layoutParams = binding.ivImage.layoutParams as LinearLayout.LayoutParams
        val space = DensityUtils.dpToPx(context, 30f)
        //2列的瀑布流，屏幕宽度减去两列间的间距space所的值再除以2，计算出单列的imageview的宽度，space的值在RecyclerView初始化时传入
        val itemWidth: Float = (DisplayUtils.getScreenWidth(context) - space.toFloat()) / 2
        layoutParams.width = itemWidth.toInt()
        val width = card.width.toFloat()
        val height = card.height.toFloat()
        val scale = height / width
        if (holder.layoutPosition % 2 == 1) {
            //采用3:4显示
            layoutParams.height = (itemWidth * SCALE).toInt()
        } else {
            //采用1:1显示
            layoutParams.height = itemWidth.toInt()
        }
        binding.ivImage.setLayoutParams(layoutParams)

    }
}