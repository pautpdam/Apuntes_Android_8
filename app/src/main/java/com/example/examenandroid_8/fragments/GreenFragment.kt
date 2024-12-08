package com.example.examenandroid_8.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.examenandroid_8.R

private const val NOMBRE = "name"

class GreenFragment : Fragment() {
    private var nombre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nombre = it.getString(NOMBRE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_green, container, false)

        val txtBienvenida = view.findViewById<TextView>(R.id.txtGreen)
        txtBienvenida.setText(nombre)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(nombre: String) =
            GreenFragment().apply {
                arguments = Bundle().apply {
                    putString(NOMBRE, nombre)
                }
            }
    }
}