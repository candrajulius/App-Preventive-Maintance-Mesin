package com.candra.preventivemaintancemesin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragment: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fm,lifecycle)
{

    private val listArray: ArrayList<Fragment> = fragment

    override fun getItemCount(): Int {
        return listArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return listArray[position]
    }

}