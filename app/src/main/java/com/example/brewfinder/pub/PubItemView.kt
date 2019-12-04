package com.example.brewfinder.pub

import android.view.View
import androidx.core.view.isVisible
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.pubdata.PubItemsData
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import kotlinx.android.synthetic.main.pub_item.view.*

class PubItemView(val pubItem: PubItemsData) :
    ModelAbstractItem<PubItemsData, PubItemView.ViewHolder>(pubItem) {
    override val layoutRes = R.layout.pub_item
    override val type = R.id.pub_item

    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<PubItemView>(view) {

        override fun bindView(item: PubItemView, payloads: MutableList<Any>) {
            with(item.pubItem) {
                itemView.user_image.load(user.userAvatar) {
                    placeholder(R.drawable.ic_photo)
                }
                itemView.username.text = user.userName
//                itemView.location.text = venue.venueName
                itemView.beer_image.load(beer.beerLabel) {
                    placeholder(R.drawable.ic_photo)
                }
                itemView.beer_name.text = beer.beerName
                itemView.brewery_name.text = brewery.breweryName
                itemView.beer_rating.rating = ratingScore
                itemView.comment.isVisible = checkinComment.isNotEmpty()
                itemView.comment.text = checkinComment

            }
        }

        override fun unbindView(item: PubItemView) {
            with(itemView){
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



}