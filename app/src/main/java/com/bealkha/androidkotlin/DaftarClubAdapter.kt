package com.bealkha.androidkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class DaftarClubAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<DaftarClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, p1: Int) =
            ViewHolder(ClubUI().createView(AnkoContext.create(vg.context, vg)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.testView.text = items[position].name
        holder.test2View.text = items[position].image.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val testView = view.find<TextView>(ClubUI.testID)
        var test2View = view.find<TextView>(ClubUI.test2ID)

    }
}