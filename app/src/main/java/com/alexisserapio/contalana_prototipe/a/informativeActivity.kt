package com.alexisserapio.contalana_prototipe.a

import FadePageTransformer
import android.animation.ValueAnimator
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
        binding.viewPager.setPageTransformer(FadePageTransformer())

        // Vincular ViewPager2 con TabLayout (dots)
        // Sincroniza el TabLayout y el ViewPager2 y asigna los "drawables"
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // En lugar de texto, asignamos un ícono o drawable para la pestaña
            // Es necesario un "drawable" para que el indicador se muestre
            val initialDot = createDotDrawable(false)
            tab.icon = initialDot
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val selectedColor = getColor(R.color.darkestGreen)
                val unselectedColor = getColor(R.color.backgroundGreen)

                // Pestaña actual
                val currentTab = binding.tabLayout.getTabAt(position)
                val currentDot = currentTab?.icon as? GradientDrawable

                // Pestaña siguiente (si existe)
                val nextTab = binding.tabLayout.getTabAt(position + 1)
                val nextDot = nextTab?.icon as? GradientDrawable

                // Calcula el color intermedio usando ArgbEvaluator
                val evaluator = android.animation.ArgbEvaluator()

                // Anima el punto actual de seleccionado a no seleccionado
                if (currentDot != null) {
                    val animatedColor = evaluator.evaluate(positionOffset, selectedColor, unselectedColor) as Int
                    currentDot.setColor(animatedColor)
                }

                // Anima el punto siguiente de no seleccionado a seleccionado
                if (nextDot != null) {
                    val animatedColor = evaluator.evaluate(positionOffset, unselectedColor, selectedColor) as Int
                    nextDot.setColor(animatedColor)
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
            getColor(R.color.backgroundGreen) // El color del punto no seleccionado
        }

        return GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(dotColor)
            setSize(30, 30)
        }
    }

}