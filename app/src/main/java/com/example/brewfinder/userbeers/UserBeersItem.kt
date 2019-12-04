package com.example.brewfinder.userbeers

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.beerdata.BeerBreweryData
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import kotlinx.android.synthetic.main.user_beers_item.view.*

class UserBeersItem(model: BeerBreweryData) :
    ModelAbstractItem<BeerBreweryData, UserBeersItem.ViewHolder>(model) {

    override val layoutRes = R.layout.user_beers_item
    override val type = R.id.user_details

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<UserBeersItem>(view) {

        override fun bindView(item: UserBeersItem, payloads: MutableList<Any>) {
            with(item.model) {
                itemView.beer_label.load(beer.beerLabel) {
                    placeholder(R.drawable.ic_photo)
                }
                itemView.beer_name.text = beer.beerName
                itemView.brewery_name.text = brewery.breweryName
                itemView.beer_style.text = beer.beerStyle
                itemView.rating_score.rating = ratingScore
            }
        }

        override fun unbindView(item: UserBeersItem) {
            with(itemView) {
                beer_name.text = null
                beer_label.clear()
                brewery_name.text = null
                beer_style.text = null
                rating_score.rating = 0F
            }        }

    }
}