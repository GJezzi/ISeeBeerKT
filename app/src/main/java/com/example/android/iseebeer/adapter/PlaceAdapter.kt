package com.example.android.iseebeer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.iseebeer.R
import com.google.android.gms.location.places.Place
import kotlinx.android.synthetic.main.list_item.view.*

class PlaceAdapter(val places: MutableList<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PlaceViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bindPlace(places[position])
    }

    override fun getItemCount() = places.size

    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindPlace(place: Place) {
            with(place) {
                itemView.itemPlaceName.text = place.name
                itemView.itemPlaceAddress.text = place.address
            }
        }
    }
}