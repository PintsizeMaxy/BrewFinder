package com.example.brewfinder.brewerydetail

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.beerdata.Beer
import kotlinx.android.synthetic.main.beer_item.view.*

class BeerItemView(private val beer: Beer) : GenericBeerItemView(beer) {
    override val layoutRes = R.layout.beer_item
    override val type = R.id.beer_item

    override fun getViewHolder(v: View) = ViewHolder(v)

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        with(holder.itemView) {
            beer_label.load(beer.beerLabel) {
                placeholder(R.drawable.ic_photo)
            }
            beer_name.text = beer.beerName
            beer_style.text = beer.beerStyle
            beer_rating.text = String.format("%.2f", beer.ratingScore)
            rating.rating = beer.ratingScore.toFloat()
        }
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        with(holder.itemView) {
            beer_label.clear()
            beer_name.text = null
            beer_style.text = null
            beer_rating.text = null
            rating.rating = 0F
        }
    }
}