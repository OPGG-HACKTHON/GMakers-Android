package com.example.gmakers_android.feature.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.databinding.ListItemMyProfileBinding
import com.example.gmakers_android.util.ImageMappingUtil

class MyProfileListAdapter(private val profiles: List<Profile>): RecyclerView.Adapter<MyProfileListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMyProfileBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    inner class ViewHolder(
        private val binding: ListItemMyProfileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val profile = profiles[position]

            binding.profileCardView.tier = profile.tier ?: "NONE"
            binding.profileCardView.level = profile.level.toString()
            binding.profileCardView.summonerName = profile.summonerName

            binding.profileCardView.tierEmblem = ImageMappingUtil.getEmblemImageResource(profile.tier ?: "NONE")

            profile.preferLines.forEachIndexed { index, preferLine ->
                when (index) {
                    0 -> binding.profileCardView.lane01 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                    1 -> binding.profileCardView.lane02 = ImageMappingUtil.getPositionImageResource(preferLine.line)
                }
            }
        }
    }
}