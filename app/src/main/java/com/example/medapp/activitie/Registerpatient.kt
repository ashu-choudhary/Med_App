package com.example.medapp.activitie

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.medapp.R

class Registerpatient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_patient)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genderSpinner : Spinner = findViewById(R.id.genderSpinnerpatient)
        val insuranceSpinner : Spinner = findViewById(R.id.insurancespinner)

        val genderOptions = resources.getStringArray(R.array.gender_options)

        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)

        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = genderAdapter

        val insuranceOptions = resources.getStringArray(R.array.insurance)

        val insuranceadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, insuranceOptions)
        insuranceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        insuranceSpinner.adapter = insuranceadapter
    }
}