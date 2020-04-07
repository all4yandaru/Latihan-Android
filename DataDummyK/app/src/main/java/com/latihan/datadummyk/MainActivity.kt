package com.latihan.datadummyk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listDataName = ArrayList<Name>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_heroes.setHasFixedSize(true)

        listDataName.addAll(getListDataName())
        showRecyclerList()
    }

    private fun getListDataName(): ArrayList<Name>{
        val newName = resources.getStringArray(R.array.data_nama)

        val listName = ArrayList<Name>()
        for (position in newName.indices){
            val newListName = Name(
                newName[position]
            )
            listName.add(newListName)
        }
        return listName
    }

    private fun showRecyclerList(){
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listNameAdapter = ListHeroAdapter(listDataName)
        rv_heroes.adapter = listNameAdapter
    }
}
