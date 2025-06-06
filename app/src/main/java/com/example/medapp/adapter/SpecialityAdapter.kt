package com.example.medapp.com.example.medapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.com.example.medapp.model.Speciality

class SpecialityAdapter(
    private val items: List<Speciality>,
    private val onItemClick: (Speciality) -> Unit
) : RecyclerView.Adapter<SpecialityAdapter.SpecialityViewHolder>() {

    class SpecialityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.titleText)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_speciality, parent, false)
        return SpecialityViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
        val item = items[position]
        holder.titleText.text = item.name
        holder.imageView.setImageResource(item.imageResId)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = items.size
}