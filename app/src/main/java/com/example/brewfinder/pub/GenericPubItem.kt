package com.example.brewfinder.pub

import android.view.View
import com.example.brewfinder.data.pubdata.PubItemsData
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

open class GenericPubItem(model: PubItemsData) :
    ModelAbstractItem<PubItemsData, GenericPubItem.ViewHolder>(model) {
    override val layoutRes = 0

    override val type = 0

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<GenericPubItem>(view) {
        override fun bindView(item: GenericPubItem, payloads: MutableList<Any>) {}

        override fun unbindView(item: GenericPubItem) {}

    }
}