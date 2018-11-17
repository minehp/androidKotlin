package com.bealkha.androidkotlin
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var items: MutableList<Item> = mutableListOf()
        items.add(Item("yuda",10))
        items.add(Item("ferry",20))
        items.add(Item("mahendra",13))

        val adapter: DaftarClubAdapter = DaftarClubAdapter(this, items)
        MainActivityUI(adapter).setContentView(this)
    }


    class MainActivityUI(val mAdapter: DaftarClubAdapter) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout {
//                padding = dip(16)
                lparams(width= matchParent, height = wrapContent)

                recyclerView {
                    lparams(width= matchParent, height = wrapContent)
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = mAdapter
                }
            }
        }
    }
}

