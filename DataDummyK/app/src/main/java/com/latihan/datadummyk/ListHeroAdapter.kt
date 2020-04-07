package com.latihan.datadummyk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_activity_main_hero.view.*

class ListHeroAdapter (private val listName:
                       ArrayList<Name>): RecyclerView.Adapter<ListHeroAdapter.NameViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity_main_hero, parent, false)

        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listName.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.bind(listName[position])
    }

    class NameViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(listName: Name){
            with(itemView){
                tv_nama.text = listName.name

            }
        }
    }
}