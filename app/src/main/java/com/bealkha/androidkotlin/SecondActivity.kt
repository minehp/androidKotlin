package com.bealkha.androidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    private var name: String = ""
    private lateinit var clubNameView: TextView
    private lateinit var clubDetailView: TextView
    private lateinit var clubLogoView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)
            clubLogoView = imageView().lparams {
                width = dip(100)
                height = dip(100)
                gravity = Gravity.CENTER_HORIZONTAL
            }

            clubNameView = textView().lparams {
                gravity = Gravity.CENTER_HORIZONTAL
                setMargins(0, 20, 0, 40)
            }
            clubDetailView = textView().lparams { }
        }

        val intent = intent

        intent.getIntExtra("clubLogo", 1)?.let {
            Picasso.get().load(it).into(clubLogoView)
        }
        clubNameView.text = intent.getStringExtra("clubName")
        clubDetailView.text = intent.getStringExtra("clubDetail")


    }

}