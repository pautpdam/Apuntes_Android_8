package com.example.examenandroid_8.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.examenandroid_8.R
import com.example.examenandroid_8.fragments.ButtonsFragment
import com.example.examenandroid_8.fragments.GreenFragment
import com.example.examenandroid_8.fragments.RedFragment
import com.example.examenandroid_8.interfaces.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {
    private var isTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        isTablet = findViewById<View?>(R.id.colorsFragmentContainer) != null

        val firstFragment = supportFragmentManager.findFragmentById(R.id.buttonsFragmentContainer) as ButtonsFragment
        firstFragment.setOnClickListener(this)
    }

    override fun onButtonClick(color: String, nombre: String) {
        val nuevoFragment: Fragment

        if (color == "Green") {
            nuevoFragment = GreenFragment.newInstance(nombre)
        } else {
            nuevoFragment = RedFragment.newInstance(nombre)
        }

        if (isTablet) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.colorsFragmentContainer, nuevoFragment)
                .commit()
        } else {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.buttonsFragmentContainer, nuevoFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}