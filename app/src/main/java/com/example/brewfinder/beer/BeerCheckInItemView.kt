package com.example.brewfinder.beer

import android.view.View
import coil.api.clear
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.data.pubdata.PubItemsData
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import kotlinx.android.synthetic.main.beer_checkins_item.view.*
import kotlinx.android.synthetic.main.user_beers_item.view.*

class BeerCheckInItemView(val checkIns: PubItemsData) :
    ModelAbstractItem<PubItemsData, BeerCheckInItemView.ViewHolder>(checkIns) {

    override val layoutRes = R.layout.beer_checkins_item
    override val type = R.id.beer_checkins
    override fun getViewHolder(v: View) = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<BeerCheckInItemView>(view) {
        override fun bindView(item: BeerCheckInItemView, payloads: MutableList<Any>) {
            itemView.user_avatar.load(item.checkIns.user.userAvatar){
                placeholder(R.drawable.ic_photo)
            }
            itemView.username.text = item.checkIns.user.userName
            itemView.user_rating.rating = item.checkIns.ratingScore
        }

        override fun unbindView(item: BeerCheckInItemView) {
            itemView.user_avatar.clear()
            itemView.username.text = null
            itemView.user_rating.rating = 0F
        }

    }


}