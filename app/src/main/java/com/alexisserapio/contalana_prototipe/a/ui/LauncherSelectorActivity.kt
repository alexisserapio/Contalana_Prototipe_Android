package com.alexisserapio.contalana_prototipe.a.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import androidx.lifecycle.lifecycleScope
import com.alexisserapio.contalana_prototipe.a.data.DataStoreManager
import com.alexisserapio.contalana_prototipe.a.data.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LauncherSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        lifecycleScope.launch {
            // Leemos las preferencias guardadas
            val preferences = dataStore.data.first()
            val businessExists = preferences[DataStoreManager.BUSINESS_EXISTS] ?: false
            val formAnswered = preferences[DataStoreManager.FORM_ANSWERED] ?: false

            if (formAnswered && businessExists) {
                // Si el negocio ya existe, abrimos la activity del form
                startActivity(Intent(this@LauncherSelectorActivity, TabBarActivity::class.java))

            } else if (businessExists){

                startActivity(Intent(this@LauncherSelectorActivity, FormActivity::class.java))

            }
            else {
                // Si no existe, abrimos el flujo de configuración
                startActivity(Intent(this@LauncherSelectorActivity, welcomeActivity::class.java))
            }

            finish() // Cerramos esta activity para no volver a ella
        }
    }
}
