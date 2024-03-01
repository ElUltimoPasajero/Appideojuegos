package com.example.appvideojuegos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.appvideojuegos.Entities.Videogame

class VideogameAdapter(private val videogameList: List<Videogame>, private val onClickListener: (Videogame) -> Unit) :

    RecyclerView.Adapter<VideogameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideogameViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return VideogameViewHolder(layoutInflater.inflate(R.layout.item_videogame, parent, false))


    }

    override fun getItemCount(): Int {
        return videogameList.size
    }

    override fun onBindViewHolder(holder: VideogameViewHolder, position: Int) {
        val item = videogameList[position]
        holder.render(item, onClickListener)
    }


}