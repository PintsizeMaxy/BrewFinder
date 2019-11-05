package com.example.brewfinder.brewerydetail

import android.view.View
import com.example.brewfinder.data.beerdata.Beer
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

open class GenericBeerItemView(model: Beer) : ModelAbstractItem<Beer, GenericBeerItemView.ViewHolder>(model){

    override val layoutRes = 0
    override val type = 0

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<GenericBeerItemView>(view) {
        override fun bindView(item: GenericBeerItemView, payloads: MutableList<Any>) {}

        override fun unbindView(item: GenericBeerItemView) {}
    }
}