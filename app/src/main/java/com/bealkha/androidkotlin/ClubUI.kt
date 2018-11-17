package com.bealkha.androidkotlin

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {
    companion object {
        val testID = 1
        val test2ID = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            textView {
                id = testID
                text = "test"
            }

            textView {
                id = test2ID
                text = "test 2"
            }
        }
    }
}