package com.bealkha.androidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.padding
import org.jetbrains.anko.verticalLayout

class ListButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)
            editText {
                hint = "What is your name ?"
            }

            /*button("Say Hello") {
                backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                textColor = Color.WHITE
                onClick { toast("Hello ${name.text}!") }
            }.lparams(width= matchParent) {
                topMargin = dip(5)
            }*/
        }
    }
}