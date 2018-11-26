package com.bealkha.androidkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class DaftarClubAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<DaftarClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, p1: Int) =
            ViewHolder(ClubUI().createView(AnkoContext.create(vg.context, vg)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clubView.text = items[position].name
        items[position].image
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logoView = view.find<TextView>(ClubUI.logoID)
        var clubView = view.find<TextView>(ClubUI.clubName)

    }
}