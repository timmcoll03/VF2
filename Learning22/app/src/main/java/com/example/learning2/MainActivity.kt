package com.example.learning2

import android.app.Activity
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Initialize the SeekBar (Slider)
        val slider = findViewById<SeekBar>(R.id.seekBar)
        val textView = findViewById<TextView>(R.id.SliderValue)
        val visionComp = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.visioncomp)

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = "Slider Value: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })



        // Initialize the Button
        val myButton = findViewById<Button>(R.id.flash)
        myButton.setOnClickListener {
            val enteredText = visionComp.text.toString()
            Toast.makeText(this, enteredText, Toast.LENGTH_SHORT).show()
        }

    }
}

class CameraActivity : Activity() {
    private var mCamera: Camera? = null
    private var mPreview: CameraPreview? = null
    private var mViewfinder: CustomViewfinder? = null

    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        // Check for camera permission
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            finish() // No camera available
            return
        }

        // Initialize camera
        mCamera = Camera.open()
        mPreview = CameraPreview(this, mCamera)

        // Set up the custom viewfinder
        mViewfinder = CustomViewfinder(this, null)

        // Add Camera preview to the layout
        val layout: RelativeLayout = findViewById(R.id.layout_camera)
        layout.addView(mPreview)

        // Set the maximum size for the viewfinder (use 3/4 of screen size)
        mViewfinder.setMaxSize(
            (getResources().getDisplayMetrics().widthPixels * 0.75),
            (getResources().getDisplayMetrics().heightPixels * 0.75)
        )

        // Add the viewfinder to the layout
        layout.addView(mViewfinder)
    }

    @Override
    protected fun onResume() {
        super.onResume()
        if (mCamera == null) {
            mCamera = Camera.open()
        }
    }

    @Override
    protected fun onPause() {
        super.onPause()
        if (mCamera != null) {
            mCamera.stopPreview()
            mCamera.release()
            mCamera = null
        }
    }
}
