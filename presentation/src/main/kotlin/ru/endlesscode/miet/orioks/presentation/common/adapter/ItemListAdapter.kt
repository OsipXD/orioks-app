package ru.endlesscode.miet.orioks.presentation.common.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.endlesscode.github.presentation.common.adapter.ListItemType
import ru.endlesscode.github.util.inflateChild

abstract class ItemListAdapter<Item> : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    var showLoader = true
        set(value) {
            field = value

            if (value) {
                notifyItemInserted(loaderPosition)
            } else {
                notifyItemRemoved(loaderPosition)
            }
        }

    protected var items = emptyList<Item>()
    protected val loaderPosition
        get() = items.size


    override fun getItemViewType(position: Int): Int {
        return if (position == loaderPosition) ListItemType.LOADER else ListItemType.ITEM
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (position == loaderPosition) return

        initItemViewHolder(holder, items[position])
    }

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            ListItemType.ITEM -> createItemViewHolder(group)
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun getItemCount(): Int = if (showLoader) items.size + 1 else items.size

    abstract fun createItemViewHolder(group: ViewGroup): ItemViewHolder

    abstract fun initItemViewHolder(holder: ItemViewHolder, item: Item)

    fun initItems(items: List<Item>) {
        this.items = items
        showLoader = false
        notifyDataSetChanged()
    }

    open class ItemViewHolder(
        parent: ViewGroup,
        @LayoutRes
        layoutId: Int
    ) : RecyclerView.ViewHolder(parent.inflateChild(layoutId))
}
