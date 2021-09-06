package com.example.gmakers_android.feature.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseFragment
import com.example.gmakers_android.data.model.Profile
import com.example.gmakers_android.databinding.FragmentMyProfileListBinding
import com.example.gmakers_android.feature.detail.ui.ProfileDetailActivity
import com.example.gmakers_android.feature.main.adapter.MyProfileListAdapter
import com.example.gmakers_android.feature.main.viewmodel.MyProfileListViewModel

class MyProfileListFragment : BaseFragment<FragmentMyProfileListBinding>(R.layout.fragment_my_profile_list) {

    override val vm: MyProfileListViewModel = MyProfileListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.profiles.observe(viewLifecycleOwner, {
            val adapter = MyProfileListAdapter(it)
            adapter.itemClickListener = object : MyProfileListAdapter.ItemClickListener{
                override fun onItemClick(profile: Profile) {
                    val intent = Intent(requireActivity(), ProfileDetailActivity::class.java)
                    intent.putExtra(ProfileDetailActivity.INTENT_KEY_PROFILE_ID, profile.profileId)
                    startActivity(intent)
                }
            }
            binding.profileRv.adapter = adapter
        })

        vm.getProfiles()
    }
}