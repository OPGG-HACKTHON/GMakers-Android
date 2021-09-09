package com.example.gmakers_android.feature.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmakers_android.R
import com.example.gmakers_android.databinding.ItemChampionBinding
import com.example.gmakers_android.feature.profile.model.Champion

class ChampionAdapter (val champions : List<Champion>) :
    RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChampionViewHolder {
        val view = ItemChampionBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ChampionViewHolder(view)
    }

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        holder.bind(champions[position])
    }

    class ChampionViewHolder(val binding: ItemChampionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(champion: Champion) {

            val resourceId = binding.root.context.resources.getIdentifier(champion.name, "drawable", binding.root.context.packageName)
            binding.championImg.setImageResource(resourceId)
        }
    }
}