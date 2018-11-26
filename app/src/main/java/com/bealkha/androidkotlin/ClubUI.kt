package com.bealkha.androidkotlin

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {
    companion object {
        val logoID = 1
        val clubName = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = logoID
                setImageResource(R.drawable.img_barca)
            }
            textView {
                id = clubName
                text = "Barcelona"
            }
        }
    }
}