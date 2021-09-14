package com.example.gmakers_android.feature.profile.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseActivity
import com.example.gmakers_android.databinding.ActivityEditProfileBinding
import com.example.gmakers_android.feature.profile.model.LineRequest
import com.example.gmakers_android.feature.profile.viewmodel.EditProfileViewModel
import com.example.gmakers_android.feature.profile.viewmodel.PickChampionViewModel
import com.google.android.material.chip.Chip

class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(R.layout.activity_edit_profile) {

        override val vm : EditProfileViewModel = EditProfileViewModel()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding.backImg.setOnClickListener {
                finish()
            }

            binding.finishBtn.setOnClickListener {
                // keyword
                val chipList = ArrayList<String>()
                binding.keywordCg.checkedChipIds.forEach {
                    val chip = findViewById<Chip>(it)
                    val keyword = when (chip.text.toString()) {
                        "망나니" -> "HEADSMAN"
                        "스플릿" -> "SPLIT"
                        "탱커" -> "TANKER"
                        "갱킹" -> "GANKING"
                        "오브젝트지향" -> "ORIENTED_OBJECT"
                        "로밍" -> "ROAMING"
                        "암살자" -> "ASSASSIN"
                        "성장형" -> "GROWTH_TYPE"
                        "유틸형" -> "UTILITY_TYPE"
                        "전투민족" -> "BATTLE_NATION"
                        "한타지향" -> "ORIENTED_TOWARDS_FIGHTING"
                        else -> "HEADSMAN"
                    }

                    chipList.add(keyword)
                }
                vm.setKeywords(chipList)

                val intent = Intent(this, PickChampionActivity::class.java)
                intent.putExtra(PickChampionActivity.KEY_USER_NAME, binding.championEt.text.toString())
                intent.putExtra(PickChampionActivity.KEY_USER_COMMENT, binding.simpleEt.text.toString())
                intent.putStringArrayListExtra(PickChampionActivity.KEY_KEYWORDS, vm.keywords.value)
                intent.putParcelableArrayListExtra(PickChampionActivity.KEY_LINE, vm.preferLines)
                intent.putExtra(PickChampionActivity.KEY_RANK, vm.userRank)

                startActivity(intent)
            }

            // position 01
            binding.spinnerPosition01.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val position = when (position) {
                        0 -> "TOP"
                        1 -> "JUNGLE"
                        2 -> "MID"
                        3 -> "AD"
                        4 -> "SUP"
                        else -> "TOP"
                    }

                    vm.preferLines.find {
                        it.priority == 1
                    }.let {
                        if (it == null) {
                            val newItem = LineRequest(1, position, false)
                            vm.preferLines.add(newItem)
                        } else {
                            it.line = position
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

            // position 02
            binding.spinnerPosition02.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val position = when (position) {
                        0 -> "TOP"
                        1 -> "JUNGLE"
                        2 -> "MID"
                        3 -> "AD"
                        4 -> "SUP"
                        else -> "TOP"
                    }

                    vm.preferLines.find {
                        it.priority == 2
                    }.let {
                        if (it == null) {
                            val newItem = LineRequest(2, position, false)
                            vm.preferLines.add(newItem)
                        } else {
                            it.line = position
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

            // rank
            binding.spinnerRank.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val rank = when (position) {
                        0 -> "RANKED_SOLO"
                        1 -> "RANKED_FLEX"
                        2 -> "NONE"
                        else -> "RANKED_SOLO"
                    }

                    vm.userRank = rank
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }