package com.example.medapp.pat_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.medapp.R
import com.example.medapp.com.example.medapp.pat_fragment.DiseaseData

class Diseases_list : Fragment() {

    private lateinit var categorySpinner: Spinner
    private lateinit var diseaseSpinner: Spinner


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_diseases_list, container, false)

        categorySpinner = view.findViewById(R.id.categorySpinner)
        diseaseSpinner = view.findViewById(R.id.diseaseSpinner)

        val categoryList = DiseaseData.diseaseMap.keys.toList().sorted()
        val categoryAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoryList)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = categoryAdapter

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = categoryList[position]
                val diseases = DiseaseData.diseaseMap[selectedCategory] ?: emptyList()
                val diseaseAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, diseases)
                diseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                diseaseSpinner.adapter = diseaseAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        return view
    }
}

