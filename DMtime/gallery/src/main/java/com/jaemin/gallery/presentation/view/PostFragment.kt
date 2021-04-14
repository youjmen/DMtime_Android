package com.jaemin.gallery.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jaemin.base.BaseFragment
import com.jaemin.gallery.databinding.FragmentPostBinding


class PostFragment : BaseFragment<FragmentPostBinding>() {
    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPostBinding {
        return FragmentPostBinding.inflate(inflater, container, false)

    }

}