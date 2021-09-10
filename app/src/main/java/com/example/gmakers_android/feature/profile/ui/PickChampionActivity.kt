package com.example.gmakers_android.feature.profile.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityPickChampionBinding
import com.example.gmakers_android.feature.profile.ChampionList
import com.example.gmakers_android.feature.profile.HorizontalItemDecorator
import com.example.gmakers_android.feature.profile.VerticalItemDecorator
import com.example.gmakers_android.feature.profile.adapter.ChampionAdapter
import com.example.gmakers_android.feature.profile.model.ChampionRequest
import com.example.gmakers_android.feature.profile.model.LineRequest
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel
import com.example.gmakers_android.feature.profile.viewmodel.PickChampionViewModel

class PickChampionActivity : BaseActivity<ActivityPickChampionBinding>(R.layout.activity_pick_champion) {

    companion object {
        const val KEY_USER_NAME = "key_user_name"
        const val KEY_USER_COMMENT = "key_user_comment"
        const val KEY_KEYWORDS = "key_keywords"
        const val KEY_LINE = "key_line"
        const val KEY_RANK = "key_rank"
    }

    override val vm = PickChampionViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.getStringExtra(KEY_USER_NAME)?.let {
            vm.userName.value = it
        }

        intent.getStringExtra(KEY_USER_COMMENT)?.let {
            vm.userComment.value = it
        }

        intent.getStringArrayListExtra(KEY_KEYWORDS)?.let {
            vm.keywords.value = it
        }

        intent.getParcelableArrayListExtra<LineRequest>(KEY_LINE)?.let {
            vm.preferLines = it
        }

        intent.getStringExtra(KEY_RANK)?.let {
            vm.userRank = it
        }

        val pickChampions = findViewById<RecyclerView>(R.id.pickChampion_rc)
        val gridLayoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        pickChampions.layoutManager = gridLayoutManager
        binding.pickChampionRc.addItemDecoration(HorizontalItemDecorator(25))
        binding.pickChampionRc.addItemDecoration(VerticalItemDecorator(20))

        val adapter = ChampionAdapter(ChampionList.championNameList.toList())
        pickChampions.adapter = adapter

        binding.finishBtn.setOnClickListener {
            val championList = ArrayList<ChampionRequest>()
            adapter.selectedItems.forEachIndexed { index, i ->
                val newItem = ChampionRequest(index + 1, ChampionList.championNameList[i].id, index != 0)
                championList.add(newItem)
            }
            vm.preferChampions.value = championList

            vm.editProfileAll()
        }
    }
}