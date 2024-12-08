package com.example.examenandroid_8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.examenandroid_8.R

private const val NOMBRE = "name"

class RedFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_red, container, false)

        val txtBienvenida = view.findViewById<TextView>(R.id.txtRed)
        txtBienvenida.setText(nombre)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(nombre: String) =
            RedFragment().apply {
                arguments = Bundle().apply {
                    putString(NOMBRE, nombre)
                }
            }
    }
}