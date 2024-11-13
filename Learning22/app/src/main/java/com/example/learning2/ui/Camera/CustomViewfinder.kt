import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomViewfinder(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var viewfinderWidth = 0
    private var viewfinderHeight = 0
    private var maxWidth = 0
    private var maxHeight = 0
    private val paint = Paint()

    init {
        paint.color = Color.GREEN // Change to the desired viewfinder color
        paint.strokeWidth = 5f
    }

    // Set the maximum width and height for the viewfinder based on screen size
    fun setMaxSize(maxWidth: Int, maxHeight: Int) {
        this.maxWidth = maxWidth
        this.maxHeight = maxHeight
        updateViewfinderSize()
    }

    // Update the size of the viewfinder (maintains aspect ratio)
    fun updateViewfinderSize() {
        val aspectRatio = 16f / 9f // Use any aspect ratio you like
        if (maxWidth > 0 && maxHeight > 0) {
            if (maxWidth * aspectRatio <= maxHeight) {
                viewfinderWidth = maxWidth
                viewfinderHeight = (viewfinderWidth / aspectRatio).toInt()
            } else {
                viewfinderHeight = maxHeight
                viewfinderWidth = (viewfinderHeight * aspectRatio).toInt()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the viewfinder rectangle
        val left = width - viewfinderWidth - 50 // Position at bottom-right with margin
        val top = height - viewfinderHeight - 50
        canvas.drawRect(left.toFloat(), top.toFloat(), (left + viewfinderWidth).toFloat(), (top + viewfinderHeight).toFloat(), paint)
    }
}
