package com.alexisserapio.contalana_prototipe.a.ui


import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.lifecycleScope
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.a.data.DataStoreManager
import com.alexisserapio.contalana_prototipe.a.data.dataStore
import com.alexisserapio.contalana_prototipe.databinding.ActivityFormBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

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


        lifecycleScope.launch {
            val preferences = dataStore.data.first() // suspende hasta obtener el primer valor
            val businessName = preferences[DataStoreManager.BUSINESS_NAME] ?: ""
            binding.topLabel.text = getString(R.string.formString, businessName)


        binding.formButton.setOnClickListener {

            lifecycleScope.launch {
                saveValues()
                val segueToTabBarActivity = Intent(this@FormActivity, TabBarActivity::class.java)
                startActivity(segueToTabBarActivity)
                finish()
            }
        }
        }

    }

    private suspend fun saveValues() {
        dataStore.edit { preferences ->
            preferences[DataStoreManager.FORM_ANSWERED] = true
        }
    }
}