package com.example.gmakers_android.feature.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gmakers_android.feature.main.ui.BookMarkListFragment
import com.example.gmakers_android.feature.main.ui.MyProfileListFragment

class ProfileViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)  {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return MyProfileListFragment()
            }
            1 -> {
                return BookMarkListFragment()
            }
            else -> {
                return Fragment()
            }
        }
    }
}