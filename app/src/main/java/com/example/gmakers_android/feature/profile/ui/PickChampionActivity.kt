package com.example.gmakers_android.feature.profile.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityPickChampionBinding
import com.example.gmakers_android.feature.profile.ChampionList
import com.example.gmakers_android.feature.profile.adapter.ChampionAdapter
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel

class PickChampionActivity : BaseActivity<ActivityPickChampionBinding>(R.layout.activity_pick_champion) {

    override val vm = EditProfileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pickChampions = findViewById<RecyclerView>(R.id.pickChampion_rc)
        val gridLayoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        pickChampions.layoutManager = gridLayoutManager

        val adapter = ChampionAdapter(ChampionList.championNameList.toList())
        pickChampions.adapter = adapter
    }
}