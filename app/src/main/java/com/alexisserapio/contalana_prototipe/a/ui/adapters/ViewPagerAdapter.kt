package com.alexisserapio.contalana_prototipe.a.ui.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alexisserapio.contalana_prototipe.a.ui.fragments.HomeFragment
import com.alexisserapio.contalana_prototipe.a.ui.fragments.InventoryFragment
import com.alexisserapio.contalana_prototipe.a.ui.fragments.ManagementFragment
import com.alexisserapio.contalana_prototipe.a.ui.fragments.PlanningFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        HomeFragment(),
        InventoryFragment(),
        ManagementFragment(),
        PlanningFragment()
    )

    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}