package com.alexisserapio.contalana_prototipe.a

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.a.model.informativePage
import com.alexisserapio.contalana_prototipe.a.view.ViewPagerAdapter
import com.alexisserapio.contalana_prototipe.databinding.ActivityInformativeBinding
import androidx.viewpager2.widget.ViewPager2
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
            informativePage(getString(R.string.infoPoster_title_one),getString(R.string.infoPoster_description_one)),
            informativePage(getString(R.string.infoPoster_title_two),getString(R.string.infoPoster_description_two)),
            informativePage(getString(R.string.infoPoster_title_three),getString(R.string.infoPoster_description_three))
        )

        // Crea los "drawables" para los puntos de forma programática
        val selectedDot = createDotDrawable(isSelected = true)
        val unselectedDot = createDotDrawable(isSelected = false)


        val adapter = ViewPagerAdapter(informativeData)
        binding.viewPager.adapter = adapter
        // Vincular ViewPager2 con TabLayout (dots)
        // Sincroniza el TabLayout y el ViewPager2 y asigna los "drawables"
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // En lugar de texto, asignamos un ícono o drawable para la pestaña
            // Es necesario un "drawable" para que el indicador se muestre
            tab.icon = unselectedDot
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Iterar sobre todas las pestañas para actualizar sus "drawables"
                for (i in 0 until binding.tabLayout.tabCount) {
                    val tab = binding.tabLayout.getTabAt(i)
                    if (tab != null) {
                        tab.icon = if (i == position) selectedDot else unselectedDot
                    }
                }
            }
        })

    }

    /**
     * Función que crea un drawable de forma programática para el punto.
     * @param isSelected Define si el punto debe ser el de color seleccionado o no.
     */
    private fun createDotDrawable(isSelected: Boolean): GradientDrawable {
        val dotColor = if (isSelected) {
            getColor(R.color.darkestGreen) // El color del punto seleccionado
        } else {
            getColor(R.color.CL_darkGreen) // El color del punto no seleccionado
        }

        return GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(dotColor)
            setSize(32, 32)
        }
    }

}