package com.example.medapp.com.example.medapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R

class DiseaseAdapter(private val diseaseList: List<String>) :
    RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder>() {

    inner class DiseaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val diseaseName: TextView = itemView.findViewById(R.id.diseaseNameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.disease_item, parent, false)
        return DiseaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        holder.diseaseName.text = diseaseList[position]
    }

    override fun getItemCount(): Int = diseaseList.size
}