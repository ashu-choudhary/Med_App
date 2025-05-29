package com.example.medapp.activitie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.medapp.R
import com.example.medapp.doc_activites.Registerdoctor
import com.example.medapp.pat_activites.Registerpatient

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

        val button1 = findViewById<Button>(R.id.btn_patient)
        val button2 = findViewById<Button>(R.id.btn_doctor)

        button1.setOnClickListener {
            val intent = Intent(this, Registerpatient::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, Registerdoctor::class.java)
            startActivity(intent)
        }

        val Login = findViewById<TextView>(R.id.txt_login)
        Login.setOnClickListener {
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
        }
    }
}