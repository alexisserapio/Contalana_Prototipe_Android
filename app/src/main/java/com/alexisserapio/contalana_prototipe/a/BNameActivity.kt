package com.alexisserapio.contalana_prototipe.a

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.contalana_prototipe.R
import com.alexisserapio.contalana_prototipe.databinding.ActivityBnameBinding

class BNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBnameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBnameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el EditText para mostrar el botón "Done"
        binding.etBName.imeOptions = EditorInfo.IME_ACTION_DONE
        binding.etBName.setSingleLine(true)

        // Detectar cuando el usuario presiona Done
        binding.etBName.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // Ocultar el teclado
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
                v.clearFocus()
                true
            } else {
                false
            }
        }

        binding.bnameButton.setOnClickListener {
            if (binding.etBName.text.isEmpty()){
                Toast.makeText(this, getString(R.string.bName_forms_error), Toast.LENGTH_SHORT).show()
            }else{
                val segueToTutoActivity = Intent(this, TutorialActivity::class.java).apply{
                    putExtra("BNAME_KEY", binding.etBName.text.toString())
                }
                startActivity(segueToTutoActivity)
                finish()
            }
        }
    }

}