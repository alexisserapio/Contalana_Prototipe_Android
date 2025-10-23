package com.alexisserapio.contalana_prototipe.a

import android.animation.AnimatorSet
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
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }


        val animateBlueSquare = ObjectAnimator.ofFloat(binding.welcomeSquareblue, "rotation", 0f, 25f)
        val animateGreenSquare = ObjectAnimator.ofFloat(binding.welcomeSquaregreen, "rotation", 0f, -25f)
        animateBlueSquare.duration = 800 // duración en ms
        animateGreenSquare.duration = 800 // duración en ms

        val animateTitle = ObjectAnimator.ofFloat(binding.welcomeLabel, "alpha", 0f, 1f)
        val animateSubtitle = ObjectAnimator.ofFloat(binding.welcomeSubLabel, "alpha", 0f, 1f)
        val animateButton = ObjectAnimator.ofFloat(binding.welcomeButton, "alpha", 0f, 1f)
        val animateTerms = ObjectAnimator.ofFloat(binding.welcomeTerms, "alpha", 0f, 1f)
        val animateSignIn = ObjectAnimator.ofFloat(binding.welcomeSignIn, "alpha", 0f, 1f)

        animateTitle.duration = 800 // duración en ms
        animateSubtitle.duration = 500 // duración en ms
        animateButton.duration = 500 // duración en ms
        animateTerms.duration = 500
        animateSignIn.duration = 500

        val set = AnimatorSet()
        val set2 = AnimatorSet()
        set.playSequentially(animateBlueSquare, animateTitle, animateSubtitle)
        set2.playTogether( animateButton, animateTerms)
        animateGreenSquare.start()
        set.start()
        binding.root.postDelayed({
            set2.start()
        }, 2200)
        binding.root.postDelayed({
            animateSignIn.start()
        },2700)
        binding.welcomeButton.setOnClickListener {
            val segueToInformativeAct = Intent(this, InformativeActivity::class.java)
            startActivity(segueToInformativeAct)
            finish()
        }

    }
}