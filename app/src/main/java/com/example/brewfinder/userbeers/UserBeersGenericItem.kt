package com.example.brewfinder.userbeers

import android.view.View
import com.example.brewfinder.data.beerdata.BeerBreweryData
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

open class UserBeersGenericItem(model: BeerBreweryData) :
    ModelAbstractItem<BeerBreweryData, UserBeersGenericItem.ViewHolder>(model) {
    override val layoutRes = 0
    override val type = 0

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<UserBeersGenericItem>(view) {
        override fun bindView(item: UserBeersGenericItem, payloads: MutableList<Any>) {}

        override fun unbindView(item: UserBeersGenericItem) {}

    }
}