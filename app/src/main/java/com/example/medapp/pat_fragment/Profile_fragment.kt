package com.example.medapp.pat_fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.medapp.R
import com.example.medapp.db.MyDatabaseHelper

class Profile_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val txtName = view.findViewById<TextView>(R.id.txt_name)
        val txtEmail = view.findViewById<TextView>(R.id.txt_email)
        val txtAddress = view.findViewById<TextView>(R.id.txt_address)
        val txtContact = view.findViewById<TextView>(R.id.txt_contact)

        // Get the latest user info from SQLite
        val dbHelper = MyDatabaseHelper(requireContext())
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users ORDER BY id DESC LIMIT 1", null)
        if (cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
            val contact = cursor.getString(cursor.getColumnIndexOrThrow("contact"))

            txtName.text = name
            txtEmail.text = email
            txtAddress.text = address
            txtContact.text = contact
        }
        cursor.close()
        db.close()

        return view
    }
}