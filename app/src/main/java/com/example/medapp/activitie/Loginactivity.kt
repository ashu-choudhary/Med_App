package com.example.medapp.activitie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medapp.databinding.ActivityLoginBinding

class Loginactivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}