package com.example.medapp.com.example.medapp.doc_activites

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DocPad(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var path = Path()
    private var paintBrush = Paint()
    private val paths = ArrayList<Pair<Path, Paint>>()
    private val undonePaths = ArrayList<Pair<Path, Paint>>()

    fun undo() {
        if (paths.isNotEmpty()) {
            undonePaths.add(paths.removeAt(paths.lastIndex))
            invalidate()
        }
    }

    fun redo() {
        if (undonePaths.isNotEmpty()) {
            paths.add(undonePaths.removeAt(undonePaths.lastIndex))
            invalidate()
        }
    }

    fun setColor(newColor: Int) {
        paintBrush.color = newColor
    }


    init {
        paintBrush.color = Color.BLACK
        paintBrush.isAntiAlias = true
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeCap = Paint.Cap.ROUND
        paintBrush.strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for ((p, brush) in paths) {
            canvas.drawPath(p, brush)
        }

        canvas.drawPath(path, paintBrush)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(x, y)
            MotionEvent.ACTION_MOVE -> path.lineTo(x, y)
            MotionEvent.ACTION_UP -> {
                paths.add(Pair(Path(path), Paint(paintBrush)))
                path.reset()
            }
        }

        invalidate()
        return true
    }

    fun clearCanvas() {
        paths.clear()
        path.reset()
        invalidate()
    }
}
