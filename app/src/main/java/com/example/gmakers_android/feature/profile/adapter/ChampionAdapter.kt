package com.example.gmakers_android.feature.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmakers_android.feature.profile.model.ChoiceChampion

class ChampionAdapter(var model : ArrayList<ChoiceChampion>):
    RecyclerView.Adapter<ChampionAdapter.IntroChampionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroChampionViewHolder {
        val view = ItemChampionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IntroChampionViewHolder(view)
    }
    override fun getItemCount() = model.size


    fun setItem(champions: List<ChoiceChampion>) {
        this.model = champions as ArrayList<ChoiceChampion>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: IntroChampionViewHolder, p1: Int) = p0.bind(model[p1], p1)

    class IntroChampionViewHolder(itemView: ItemChampionBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val image = itemView.
        fun bind(model: ChoiceChampion, position: Int) {
            image.

            }

        }
    }
}