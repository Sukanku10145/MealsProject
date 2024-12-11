package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val btnMain = findViewById<Button>(R.id.btnMain)
        btnMain.setOnClickListener {
            goToCredit()
        }
    }

    fun goToCredit() {

        val intent = Intent(this@MainActivity, CreditActivity::class.java)

        val etMain = this.findViewById<EditText>(R.id.etMain)

        intent.putExtra("NAME", etMain.text.toString())

        startActivity(intent)
        finish()
    }
}