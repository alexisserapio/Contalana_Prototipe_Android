package com.alexisserapio.contalana_prototipe.a

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Matrix
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.databinding.ActivityWelcomeBinding

class welcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_welcome)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animator = ObjectAnimator.ofFloat(binding.welcomeImage, "rotation", 0f, 45f)
        animator.duration = 500 // duración en ms
        animator.start()


        //Setear la matriz de la imagen para utilizarla en el Style
        /*binding.welcomeImage.post {
            val matrix = Matrix()

            val drawable = binding.welcomeImage.drawable ?: return@post

            // Escalar para que la imagen quepa en el ImageView
            val scaleX = binding.welcomeImage.width.toFloat() / drawable.intrinsicWidth
            val scaleY = binding.welcomeImage.height.toFloat() / drawable.intrinsicHeight
            matrix.setScale(scaleX, scaleY)


            binding.welcomeImage.imageMatrix = matrix
        }*/

        binding.welcomeButton.setOnClickListener {
            val segueToInformativeAct = Intent(this, InformativeActivity::class.java)
            startActivity(segueToInformativeAct)
            finish()
        }

    }
}