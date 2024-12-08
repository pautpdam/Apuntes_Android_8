package com.example.examenandroid_8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.examenandroid_8.R
import com.example.examenandroid_8.interfaces.OnClickListener
import com.google.android.material.textfield.TextInputLayout

class ButtonsFragment : Fragment() {
    private var listener: OnClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buttons, container, false)

        val btnGreen = view.findViewById<Button>(R.id.btnGreenFragment)
        val btnRed = view.findViewById<Button>(R.id.btnRedFragment)
        val inNombre = view.findViewById<TextInputLayout>(R.id.inNombre)

        btnGreen.setOnClickListener {
            val nombre = inNombre.editText?.text.toString()
            listener?.onButtonClick("Green", nombre)
        }

        btnRed.setOnClickListener {
            val nombre = inNombre.editText?.text.toString()
            listener?.onButtonClick("Red", nombre)
        }

        return view
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }
}