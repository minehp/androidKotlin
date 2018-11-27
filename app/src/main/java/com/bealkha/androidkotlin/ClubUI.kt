package com.bealkha.androidkotlin

import android.text.Layout
import android.view.Gravity
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
            .lparams {
                width = dip(50)
                height = dip(50)
            }

            textView {
                id = clubName
                text = "Barcelona"
            }
            .lparams {
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
                width = wrapContent
                height = wrapContent
            }
        }
    }
}