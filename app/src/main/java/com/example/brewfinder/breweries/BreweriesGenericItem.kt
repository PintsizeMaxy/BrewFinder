package com.example.brewfinder.breweries

import android.view.View
import com.example.brewfinder.data.brewerydata.Brewery
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

open class BreweriesGenericItem (model: Brewery) : ModelAbstractItem<Brewery, BreweriesGenericItem.ViewHolder>(model){
    override val layoutRes = 0
    override val type = 0

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<BreweriesGenericItem>(view){
        override fun bindView(item: BreweriesGenericItem, payloads: MutableList<Any>) {}

        override fun unbindView(item: BreweriesGenericItem) {}

    }
}