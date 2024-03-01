package com.example.appvideojuegos

import android.icu.number.IntegerWidth
import android.view.ContextMenu
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appvideojuegos.Entities.Videogame
import com.example.appvideojuegos.databinding.ItemVideogameBinding

class VideogameViewHolder(view: View):ViewHolder(view), View.OnCreateContextMenuListener {

    val binding = ItemVideogameBinding.bind(view)
    private lateinit var videogame : Videogame


    fun render (item: Videogame, onClickListener:(Videogame)->Unit){

        videogame= item

        binding.tvVideogameName.text=item.name
        binding.gameImg.setImageResource(item.image)
        binding.tvYear.setText(item.year.toString())
        binding.tvPlatform.setText(item.platform)

        itemView.setOnClickListener{
            onClickListener(item)
        }
itemView.setOnCreateContextMenuListener(this)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu!!.setHeaderTitle(videogame.name)

        menu.add(this.adapterPosition,0,0,"Edit")

    }


}