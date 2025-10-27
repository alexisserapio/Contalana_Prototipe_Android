package com.alexisserapio.contalana_prototipe.a.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.a.ui.adapters.ViewPagerAdapter
import com.alexisserapio.contalana_prototipe.databinding.ActivityTabBarBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBarBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)

        // Vincular TabLayout y ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.item_one)
                    tab.setIcon(R.drawable.ic_home)
                }

                1 -> {
                    tab.text = getString(R.string.item_two)
                    tab.setIcon(R.drawable.ic_inventory)
                }
                2 -> {
                    tab.text = getString(R.string.item_three)
                    tab.setIcon(R.drawable.ic_management)
                }
                3 -> {
                    tab.text = getString(R.string.item_four)
                    tab.setIcon(R.drawable.ic_planning)
                }
            }
        }.attach()
    }
}
