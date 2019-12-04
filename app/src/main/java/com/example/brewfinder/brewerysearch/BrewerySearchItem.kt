package com.example.brewfinder.brewerysearch

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.brewerydata.Brewery
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import kotlinx.android.synthetic.main.brewery_item.view.*


class BrewerySearchItem(val breweries: Brewery) :
    ModelAbstractItem<Brewery, BrewerySearchItem.ViewHolder>(breweries) {
    override val layoutRes = R.layout.brewery_item
    override val type = R.id.brewery_item
    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<BrewerySearchItem>(view) {

        override fun bindView(item: BrewerySearchItem, payloads: MutableList<Any>) {
            with(item.breweries) {
                itemView.brewery_logo.load(breweryLabel) {
                    placeholder(R.drawable.ic_photo)
                }
                itemView.brewery_name.text = breweryName
            }
        }

        override fun unbindView(item: BrewerySearchItem) {
            with(itemView) {
                brewery_logo.clear()
                brewery_name.text = null
            }
        }
    }
}