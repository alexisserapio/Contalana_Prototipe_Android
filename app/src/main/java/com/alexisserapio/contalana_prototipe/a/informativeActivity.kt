package com.alexisserapio.contalana_prototipe.a

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.a.model.informativePage
import com.alexisserapio.contalana_prototipe.a.view.ViewPagerAdapter
import com.alexisserapio.contalana_prototipe.databinding.ActivityInformativeBinding
import com.google.android.material.tabs.TabLayoutMediator

class informativeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInformativeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityInformativeBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.informative)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val informativeData = listOf(
            informativePage(getString(R.string.infoPoster_title_one),getString(R.string.infoPoster_description_one), getString(R.string.infoPoster_firstImage)),
            informativePage(getString(R.string.infoPoster_title_two),getString(R.string.infoPoster_description_two), getString(R.string.infoPoster_firstImage)),
            informativePage(getString(R.string.infoPoster_title_three),getString(R.string.infoPoster_description_three), getString(R.string.infoPoster_firstImage))
        )

        val adapter = ViewPagerAdapter(informativeData)
        binding.viewPager.adapter = adapter
        // Vincular ViewPager2 con TabLayout (dots)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

    }
}