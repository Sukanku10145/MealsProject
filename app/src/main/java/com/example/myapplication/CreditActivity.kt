package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_credit)

        val tvCre1 = findViewById<TextView>(R.id.tvCre1)

        val nombre = intent.getStringExtra("NAME")

        tvCre1.apply {
            text = getString(R.string.tvCre1,nombre)
        }

        val btnCre = findViewById<Button>(R.id.btnCre)
        btnCre.setOnClickListener(){
            val email = Intent().apply {
                val nombreApp = getString(R.string.app_name)
                action = Intent.ACTION_SEND
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("jrodper914@gmailcom"))
                putExtra(Intent.EXTRA_TEXT, "Consulta de la app $nombreApp")
                type = "text/plain"
            }
            try {
                startActivity(email)
            }catch (e: ActivityNotFoundException){
                println("ERROR")
            }
        }
    }
}