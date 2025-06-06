package com.example.medapp.pat_fragment

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import com.example.medapp.R
import com.example.medapp.db.MyDatabaseHelper

class Personal_details_fragment : Fragment() {

    private var isInEditMode = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal_details, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val heightInput = view.findViewById<EditText>(R.id.heightInput)
        val weightInput = view.findViewById<EditText>(R.id.weightInput)
        val ageInput = view.findViewById<EditText>(R.id.ageInput)
        val bloodGroupDropdown = view.findViewById<AutoCompleteTextView>(R.id.bloodGroupDropdown)
        val sexDropdown = view.findViewById<AutoCompleteTextView>(R.id.sexDropdown)
        val editButton = view.findViewById<Button>(R.id.editButton)

        val bloodGroups = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
        val sexes = arrayOf("Male", "Female", "Other")

        bloodGroupDropdown.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, bloodGroups))
        sexDropdown.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, sexes))

        bloodGroupDropdown.setOnTouchListener { v, event ->
            bloodGroupDropdown.showDropDown()
            false
        }
        sexDropdown.setOnTouchListener { v, event ->
            sexDropdown.showDropDown()
            false
        }

        // 1. Load saved data from SQLite
        loadPersonalDetails(heightInput, weightInput, ageInput, bloodGroupDropdown, sexDropdown)

        // Initially disable editing
        setFieldsEnabled(false, heightInput, weightInput, ageInput, bloodGroupDropdown, sexDropdown)

        editButton.setOnClickListener {
            if (isInEditMode) {
                // Save to SQLite
                savePersonalDetails(heightInput, weightInput, ageInput, bloodGroupDropdown, sexDropdown)
            }
            isInEditMode = !isInEditMode
            setFieldsEnabled(isInEditMode, heightInput, weightInput, ageInput, bloodGroupDropdown, sexDropdown)
            editButton.text = if (isInEditMode) "Save" else "Edit"
        }
    }

    private fun setFieldsEnabled(enabled: Boolean, vararg views: View) {
        views.forEach { view ->
            view.isEnabled = enabled
            if (view is EditText || view is AutoCompleteTextView) {
                view.isFocusable = enabled
                view.isFocusableInTouchMode = enabled
            }
        }
    }

    private fun savePersonalDetails(
        heightInput: EditText,
        weightInput: EditText,
        ageInput: EditText,
        bloodGroupDropdown: AutoCompleteTextView,
        sexDropdown: AutoCompleteTextView
    ) {
        val dbHelper = MyDatabaseHelper(requireContext())
        val db = dbHelper.writableDatabase

        // For demo: update the latest user
        val cursor = db.rawQuery("SELECT id FROM users ORDER BY id DESC LIMIT 1", null)
        var userId: Int? = null
        if (cursor.moveToFirst()) {
            userId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
        }
        cursor.close()

        if (userId != null) {
            val values = ContentValues().apply {
                put("height", heightInput.text.toString())
                put("weight", weightInput.text.toString())
                put("age", ageInput.text.toString())
                put("blood_group", bloodGroupDropdown.text.toString())
                put("sex", sexDropdown.text.toString())
            }
            db.update("users", values, "id=?", arrayOf(userId.toString()))
        }
        db.close()
    }

    private fun loadPersonalDetails(
        heightInput: EditText,
        weightInput: EditText,
        ageInput: EditText,
        bloodGroupDropdown: AutoCompleteTextView,
        sexDropdown: AutoCompleteTextView
    ) {
        val dbHelper = MyDatabaseHelper(requireContext())
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users ORDER BY id DESC LIMIT 1", null)
        if (cursor.moveToFirst()) {
            heightInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("height")))
            weightInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("weight")))
            ageInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("age")))
            bloodGroupDropdown.setText(cursor.getString(cursor.getColumnIndexOrThrow("blood_group")), false)
            sexDropdown.setText(cursor.getString(cursor.getColumnIndexOrThrow("sex")), false)
        }
        cursor.close()
        db.close()
    }
}