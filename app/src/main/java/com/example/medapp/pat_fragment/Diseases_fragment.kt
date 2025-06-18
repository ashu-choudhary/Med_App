package com.example.medapp.com.example.medapp.pat_fragment

import android.content.res.Configuration
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.com.example.medapp.adapter.SpecialityAdapter
import com.example.medapp.com.example.medapp.model.Speciality

class Diseases_fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SpecialityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_diseases, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        val spacing = resources.getDimensionPixelSize(R.dimen.recycler_spacing)
        val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2

        recyclerView.layoutManager = GridLayoutManager(requireContext(), spanCount)

        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing))

        val specialityList = listOf(
            Speciality("Brain", R.drawable.brain),
            Speciality("Eyes", R.drawable.eyes),
            Speciality("Nose", R.drawable.noes),
            Speciality("Ears", R.drawable.ear),
            Speciality("Throat", R.drawable.throat),
            Speciality("Heart", R.drawable.heart),
            Speciality("Lungs", R.drawable.lungs),
            Speciality("Stomach", R.drawable.stomach),
            Speciality("Kidney", R.drawable.kidney),
            Speciality("Liver", R.drawable.liver),
            Speciality("Venereologist", R.drawable.venereologist),
            Speciality("Legs", R.drawable.legs)
        )

        adapter = SpecialityAdapter(specialityList) { selectedSpeciality ->
            val fragment = dieaseas_type()
            fragment.arguments = Bundle().apply {
                putString("specialty", selectedSpeciality.name)
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit()
        }


        recyclerView.adapter = adapter
    }


    class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            val column = position % spanCount

            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount
            outRect.top = if (position < spanCount) spacing else 0
            outRect.bottom = spacing
        }
    }

}