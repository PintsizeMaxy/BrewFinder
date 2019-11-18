package com.example.brewfinder.userbeers

import android.content.Context
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.beerdata.BeerBreweryData
import kotlinx.android.synthetic.main.user_beers_item.view.*

class UserBeersItem(model: BeerBreweryData) : UserBeersGenericItem(model) {

    override val layoutRes = R.layout.user_beers_item
    override val type = R.id.user_details

    override fun getViewHolder(v: View) = ViewHolder(v)

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        with(holder.itemView){
            beer_label.load(model.beer.beerLabel){
                placeholder(R.drawable.ic_photo)
            }
            beer_name.text = model.beer.beerName
            brewery_name.text = model.brewery.breweryName
            beer_style.text = model.beer.beerStyle
        }
    }

    override fun createView(ctx: Context, parent: ViewGroup?): View {
        return super.createView(ctx, parent)
    }
}