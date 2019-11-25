package com.example.brewfinder.brewerysearch

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.brewerydata.Brewery
import kotlinx.android.synthetic.main.brewery_item.view.*


class BrewerySearchItem(private val breweries: Brewery) : BrewerySearchGenericItem(breweries)
{
    override val layoutRes = R.layout.brewery_item
    override val type = R.id.brewery_item
    override fun getViewHolder(v: View) = ViewHolder(v)
    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        with(holder.itemView) {
            brewery_logo.load(model.breweryLabel) {
                placeholder(R.drawable.ic_photo)
            }
            brewery_name.text = model.breweryName
        }
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        with(holder.itemView){
            brewery_logo.clear()
            brewery_name.text = null
        }
    }
}