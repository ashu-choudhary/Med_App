package com.example.medapp.doc_fragment

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.com.example.medapp.doc_activites.DocPad
import java.io.File
import java.io.FileOutputStream
import androidx.core.graphics.createBitmap
import yuku.ambilwarna.AmbilWarnaDialog
import android.graphics.Color
import android.content.ContentValues
import android.os.Environment
import android.provider.MediaStore
import java.io.OutputStream



class DoctorPad : Fragment() {

    private lateinit var drawingView: DocPad

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_pad, container, false)

        drawingView = view.findViewById(R.id.drawing_view)



        view.findViewById<Button>(R.id.clear_button).setOnClickListener {
            drawingView.clearCanvas()
        }

        view.findViewById<Button>(R.id.undo_button).setOnClickListener {
            drawingView.undo()
        }

        view.findViewById<Button>(R.id.redo_button).setOnClickListener {
            drawingView.redo()
        }

        view.findViewById<Button>(R.id.color_button).setOnClickListener {
            val colorPicker = AmbilWarnaDialog(requireContext(), Color.BLACK,
                object : AmbilWarnaDialog.OnAmbilWarnaListener {
                    override fun onCancel(dialog: AmbilWarnaDialog?) {}

                    override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                        drawingView.setColor(color)
                    }
                })
            colorPicker.show()
        }


        view.findViewById<Button>(R.id.save_button).setOnClickListener {
            saveCanvasAsImage()
        }

        return view
    }

    private fun saveCanvasAsImage() {
        val bitmap = createBitmap(drawingView.width, drawingView.height)
        val canvas = Canvas(bitmap)
        drawingView.draw(canvas)

        val filename = "Drawing_${System.currentTimeMillis()}.png"
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, filename)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/MedApp") // Folder name
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        val resolver = requireContext().contentResolver
        val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

        uri?.let {
            val stream: OutputStream? = resolver.openOutputStream(it)
            stream?.use {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
            }

            contentValues.clear()
            contentValues.put(MediaStore.Images.Media.IS_PENDING, 0)
            resolver.update(uri, contentValues, null, null)

            Toast.makeText(requireContext(), "Saved to Pictures/MedApp", Toast.LENGTH_LONG).show()
        } ?: run {
            Toast.makeText(requireContext(), "Failed to save image", Toast.LENGTH_SHORT).show()
        }
    }
}