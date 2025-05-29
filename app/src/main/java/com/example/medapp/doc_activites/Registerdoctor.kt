package com.example.medapp.doc_activites

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.medapp.R
import com.example.medapp.activitie.Loginactivity

class Registerdoctor : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register_doctor)



        val Login = findViewById<TextView>(R.id.txt_login)

        // Set Click Listener
        Login.setOnClickListener {
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
        }



    }

}