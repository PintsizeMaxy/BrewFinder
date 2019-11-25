package com.example.brewfinder.brewerysearch

import android.view.View
import com.example.brewfinder.data.brewerydata.Brewery
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

open class BrewerySearchGenericItem(model: Brewery) :
    ModelAbstractItem<Brewery, BrewerySearchGenericItem.ViewHolder>(model) {
    override val layoutRes = 0
    override val type = 0

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<BrewerySearchGenericItem>(view) {
        override fun bindView(item: BrewerySearchGenericItem, payloads: MutableList<Any>) {}

        override fun unbindView(item: BrewerySearchGenericItem) {}

    }
}