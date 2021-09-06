package com.example.gmakers_android.feature.main.ui

import android.os.Bundle
import android.view.View
import com.example.gmakers_android.R
import com.example.gmakers_android.base.BaseFragment
import com.example.gmakers_android.databinding.FragmentBookMarkListBinding
import com.example.gmakers_android.feature.main.viewmodel.BookMarkListViewModel

class BookMarkListFragment : BaseFragment<FragmentBookMarkListBinding>(R.layout.fragment_book_mark_list) {

    override val vm: BookMarkListViewModel = BookMarkListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}