package com.example.brewfinder.beer

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.beerdata.Beer
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import kotlinx.android.synthetic.main.beer_item.view.*

class BeerItemView(val beer: Beer) : ModelAbstractItem<Beer, BeerItemView.ViewHolder>(beer) {
    override val layoutRes = R.layout.beer_item
    override val type = R.id.beer_item

    override fun getViewHolder(v: View) =
        ViewHolder(v)


    class ViewHolder(view: View) : FastAdapter.ViewHolder<BeerItemView>(view) {

        override fun bindView(item: BeerItemView, payloads: MutableList<Any>) {
            with(item.beer) {
                itemView.beer_label.load(beerLabel) {
                    placeholder(R.drawable.ic_photo)
                }
                itemView.beer_name.text = beerName
                itemView.beer_style.text = beerStyle
                itemView.beer_rating.text = String.format("%.1f", ratingScore)
                itemView.rating.rating = ratingScore
            }
        }

        override fun unbindView(item: BeerItemView) {
            with(itemView) {
                beer_label.clear()
                beer_name.text = null
                beer_style.text = null
                beer_rating.text = null
                rating.rating = 0F
            }
        }
    }
}