package com.example.medapp.pat_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.compose.material3.Button
import com.example.medapp.R


class Personal_details_fragment : Fragment() {

    private var isInEditMode = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal_details, container, false)
    }

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

        val bloodGroupAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, bloodGroups)
        val sexAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, sexes)

        bloodGroupDropdown.setAdapter(bloodGroupAdapter)
        sexDropdown.setAdapter(sexAdapter)

        bloodGroupDropdown.setOnClickListener {
            if (bloodGroupDropdown.isEnabled) bloodGroupDropdown.showDropDown()
        }

        sexDropdown.setOnClickListener {
            if (sexDropdown.isEnabled) sexDropdown.showDropDown()
        }

        // Initially disable editing
        setFieldsEnabled(false, heightInput, weightInput, ageInput, bloodGroupDropdown, sexDropdown)

        editButton.setOnClickListener {
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


}
