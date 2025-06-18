package com.example.medapp.com.example.medapp.pat_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.com.example.medapp.adapter.DiseaseAdapter

class dieaseas_type : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val diseaseMap = mapOf(
        "Brain" to listOf(
            "Alzheimer’s Disease", "Amyotrophic Lateral Sclerosis (ALS)", "Bell’s Palsy",
            "Brain Tumor", "Cerebral Aneurysm", "Cerebral Palsy", "Encephalitis",
            "Epilepsy", "Guillain-Barré Syndrome", "Headache", "Huntington’s Disease",
            "Hydrocephalus", "Meningitis", "Migraine", "Multiple Sclerosis",
            "Parkinson’s Disease", "Progressive Supranuclear Palsy", "Stroke",
            "Traumatic Brain Injury (TBI)"
        ),
        "Eyes" to listOf(
            "Refractive Errors", "Myopia", "Hyperopia", "Astigmatism", "Presbyopia",
            "Cataracts", "Glaucoma", "AMD", "Diabetic Retinopathy", "Retinal Detachment",
            "Uveitis", "Conjunctivitis", "Blepharitis", "Keratoconus", "Amblyopia",
            "Strabismus", "Dry Eye", "Retinitis Pigmentosa", "Color Blindness",
            "Floaters", "Stye"
        ),
        "Ears" to listOf(
            "Otitis Externa", "Otitis Media", "Mastoiditis", "Myringitis",
            "Noise-Induced Hearing Loss", "Otosclerosis", "Meniere’s Disease",
            "Acoustic Neuroma", "Labyrinthitis", "Vertigo", "Nystagmus", "Ear Wax",
            "Glue Ear", "Pendred Syndrome", "Sudden Deafness", "Tinnitus",
            "Usher Syndrome", "Vestibular Schwannoma", "Neurofibromatosis"
        ),
        "Nose" to listOf(
            "Allergic Rhinitis", "Rhinitis", "Chronic Rhinosinusitis", "Sinusitis",
            "Nasal Polyps", "Nasal Fractures", "Epistaxis", "Anosmia", "CSF Leak",
            "Nasal Tumors", "Nasal Septal Abscess", "Nasal Obstruction", "AERD"
        ),
        "Heart" to listOf(
            "Heart Attack", "Arrhythmia", "Bradycardia", "Atherosclerosis",
            "Congenital Heart Disease", "Cardiomyopathy", "Myocarditis",
            "Heart Failure", "Pulmonary Hypertension", "Atrial Fibrillation",
            "Pericarditis", "Coronary Artery Disease", "High Blood Pressure"
        ),
        "Lungs" to listOf(
            "Asthma", "Bronchitis", "Pneumonia", "Emphysema", "Pulmonary Embolism",
            "COPD", "Interstitial Lung Disease", "Pneumothorax", "Tuberculosis"
        ),
        "Stomach" to listOf(
            "Gastritis", "GERD", "Peptic Ulcers", "Stomach Cancer",
            "Irritable Bowel Syndrome", "IBD", "Food Poisoning", "Nausea and Vomiting"
        ),
        "Liver" to listOf(
            "Hepatitis A", "Hepatitis B", "Hepatitis C", "Cirrhosis",
            "Fatty Liver", "Liver Cancer", "Autoimmune Hepatitis"
        ),
        "Kidney" to listOf(
            "Chronic Kidney Disease", "Kidney Stones", "Acute Kidney Injury",
            "Glomerulonephritis", "Polycystic Kidney Disease"
        ),
        "Throat" to listOf(
            "Tonsillitis", "Pharyngitis", "Laryngitis", "Throat Cancer",
            "Strep Throat", "Vocal Cord Nodules"
        ),
        "Legs" to listOf(
            "Varicose Veins", "Deep Vein Thrombosis", "Peripheral Artery Disease",
            "Leg Ulcers", "Sciatica"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dieaseas_type, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.diseaseRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val specialty = arguments?.getString("specialty") ?: return
        val diseaseList = diseaseMap[specialty] ?: emptyList()

        recyclerView.adapter = DiseaseAdapter(diseaseList)
    }


}