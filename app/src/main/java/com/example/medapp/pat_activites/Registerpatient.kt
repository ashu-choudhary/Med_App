package com.example.medapp.pat_activites

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.medapp.R
import com.example.medapp.activitie.Loginactivity
import com.example.medapp.db.MyDatabaseHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import android.content.ContentValues
import android.util.Log

class Registerpatient : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_patient)

        auth = FirebaseAuth.getInstance()

        val nameEditText = findViewById<EditText>(R.id.et_name)
        val emailEditText = findViewById<EditText>(R.id.et_email)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val phoneEditText = findViewById<EditText>(R.id.et_mobile)
        val addressEditText = findViewById<EditText>(R.id.et_address)
        val registerButton = findViewById<Button>(R.id.btnSubmit)
        val loginText = findViewById<TextView>(R.id.txt_regster)

        val dbHelper = MyDatabaseHelper(this)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val address = addressEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                            Log.d("DB_DEBUG", "Calling insertUser with: $name, $email, $phone, $address, $password")
                            insertUser(dbHelper, name, email, phone, address, password)
                            Log.d("DB_DEBUG", "User inserted successfully")
                            Toast.makeText(this, "data inserted Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, Loginactivity::class.java))
                            finish()



                        } else {
                            Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
        val db = dbHelper.writableDatabase // This will create the db and table if not exists
        db.close()


        loginText.setOnClickListener {
            startActivity(Intent(this, Loginactivity::class.java))
            finish()
        }
    }

    // Insert user into SQLite database
    fun insertUser(dbHelper: MyDatabaseHelper, name: String, email: String, contact: String, address: String, password: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("email", email)
            put("contact", contact)
            put("address", address)
            put("password", password)
        }
        val result = db.insert("users", null, values)
        Log.d("DB_DEBUG", "Insert result: $result")
        db.close()
    }

}