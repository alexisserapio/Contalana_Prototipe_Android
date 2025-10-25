package com.alexisserapio.contalana_prototipe.a.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFormBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val BName = intent.getStringExtra("BNAME_KEY")
        binding.topLabel.text = getResources().getString(R.string.tutorialstring, BName)
    }
}