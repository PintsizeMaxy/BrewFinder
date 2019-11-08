package com.example.brewfinder.pub

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.pubdata.PubItemsData
import kotlinx.android.synthetic.main.pub_item.view.*

class PubItemView(model: PubItemsData) : GenericPubItem(model) {
    override val layoutRes = R.layout.pub_item
    override val type = R.id.pub_item

    override fun getViewHolder(v: View) = ViewHolder(v)

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        with(holder.itemView) {
            user_image.load(model.user.userAvatar) {
                placeholder(R.drawable.ic_photo)
            }
            username.text = model.user.userName
            location.text = model.venue.venueName
            beer_image.load(model.beer.beerLabel){
                placeholder(R.drawable.ic_photo)
            }
            beer_name.text = model.beer.beerName
            brewery_name.text = model.brewery.breweryName
            beer_rating.rating = model.ratingScore
            comment.text = model.checkinComment

        }
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        with(holder.itemView){
            user_image.clear()
            username.text = null
            location.text = null
            beer_image.clear()
            beer_name.text = null
            brewery_name.text = null
            beer_rating.rating = 0F
            comment.text = null
        }
    }
}