package com.example.medapp.activitie

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.medapp.R
import com.example.medapp.databinding.ActivityLoginBinding

class Loginactivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val forgetPasswordText = findViewById<TextView>(R.id.txt_passforgot)

        // Set Click Listener
        forgetPasswordText.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }

        val registerText = findViewById<TextView>(R.id.txt_regster)

        // Set Click Listener
        registerText.setOnClickListener {
            val intent = Intent(this, Firstpage::class.java)
            startActivity(intent)
        }

    }

}