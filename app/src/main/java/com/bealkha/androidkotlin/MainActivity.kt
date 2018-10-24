package com.bealkha.androidkotlin

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : Activity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/

        /*val list = findViewById<RecyclerView>(R.id.club_list)
        initData()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items) {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
        }*/

        /*initData()
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
        }*/
        ankoUITrial().setContentView(this)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for( i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i,0)))
        }
        image.recycle()
    }

    class ankoUITrial: AnkoComponent<MainActivity>, AnkoLogger {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                imageView(R.drawable.img_arsenal).lparams(width= matchParent) {
                    padding = dip(20)
                    margin = dip(15)
                }

                val name = editText() {
                    hint = "What's your name ?"
                }

                val btn = button("Say Hello")
                btn.setOnClickListener {
                    info("Halloooooooooooo ====================")
                }
            }
        }
    }
}
