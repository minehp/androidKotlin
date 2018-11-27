package com.bealkha.androidkotlin
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.club_detail)
        val image = resources.obtainTypedArray(R.array.club_image)

        var items: MutableList<Item> = mutableListOf()
        for(i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i,0),detail[i]))
        }

        val adapter: DaftarClubAdapter = DaftarClubAdapter(this, items) {
//            startActivity<SecondActivity>("clubName" to it.name,)
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("clubName", it.name)
            intent.putExtra("clubLogo", it.image)
            intent.putExtra("clubDetail", it.detail)
            startActivity(intent)
        }
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

