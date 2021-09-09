package com.example.gmakers_android.feature.profile.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmakers_android.R
import com.example.gmakers_android.feature.profile.ChampionList

class ChampionAdapter (val champions : List<ChampionList>) :
    RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChampionViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_champion, p0, false)
        return ChampionViewHolder(view)
    }

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(p0: ChampionViewHolder, p1: Int) = p0.bind(champions[0])

    class ChampionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceType")
        val image = itemView.findViewById<ImageView>(R.id.champion_img)
        fun bind(championList: ChampionList) {
            Glide.with(image)
                .load(R.drawable.amumu)
                .into(image)

        }

    }
}