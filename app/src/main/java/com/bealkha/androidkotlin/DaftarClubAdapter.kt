package com.bealkha.androidkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class DaftarClubAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<DaftarClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, p1: Int) =
            ViewHolder(ClubUI().createView(AnkoContext.create(vg.context, vg)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logoView = view.find<ImageView>(ClubUI.logoID)
        var clubView = view.find<TextView>(ClubUI.clubName)

        fun bindItem(value: Item, listener: (Item) -> Unit) {
            clubView.text = value.name
            value.image?.let { Picasso.get().load(it).into(logoView) }
            itemView.setOnClickListener {
                listener(value)
            }
        }
    }

}