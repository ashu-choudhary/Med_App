package com.example.medapp.activitie

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.medapp.R

class Firstpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_firstpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val currentlayout = findViewById<ViewGroup>(R.id.main)

        val button1 = findViewById<Button>(R.id.btn_patient)
        val button2 = findViewById<Button>(R.id.btn_doctor)


        val newlayout1 = layoutInflater.inflate(R.layout.activity_register_patient, currentlayout, false)
        val newlayout2 = layoutInflater.inflate(R.layout.activity_register_doctor, currentlayout, false)

        button1.setOnClickListener {
            currentlayout.removeAllViews()
            currentlayout.addView(newlayout1)
        }

        button2.setOnClickListener {
            currentlayout.removeAllViews()
            currentlayout.addView(newlayout2)
        }

        val Login = findViewById<TextView>(R.id.txt_login)

        // Set Click Listener
        Login.setOnClickListener {
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
        }

    }
}