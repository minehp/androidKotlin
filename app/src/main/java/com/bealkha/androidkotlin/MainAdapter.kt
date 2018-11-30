package com.bealkha.androidkotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import com.bealkha.androidkotlin.R.id.*

class MainAdapter(private val teams: List<Team>) : RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        return holder.bindItem(teams[position])
    }
}

class TeamViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
    private val teamBadge: ImageView = containerView.find(team_badge)
    private val teamName: TextView = containerView.find(team_name)
    fun bindItem(teams: Team) {
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName
    }
}

class TeamUI: AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = team_badge
                }.lparams(width = dip(50), height = dip(50))

                textView {
                    id = team_name
                    textSize = 16f
                }.lparams { margin = dip(15) }
            }
        }
    }
}