package com.example.learning2

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar

import android.widget.TextView
import android.widget.Toast
import com.example.learning2.databinding.ActivityMainBinding
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.io.File


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Initialize the SeekBar (Slider)
        val slider = findViewById<SeekBar>(R.id.seekBar)
        val visionComp = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.visioncomp)

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
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
//        val path = "C:\Users\timot\Downloads\sample_1280×853.bmp"
//        val file = File(path)
//        val bitmap = null
//        if (file.exists()) {
//            bitmap = BitmapFactory.decodeFile(path)
//        }
//
//        val detector = FirebaseVision.getInstance().visionCloudLandmarkDetector
//        val image = FirebaseVisionImage.fromBitmap(bitmap)
//        detector.detectInImage(image)
//            .addOnSuccessListener {
//                // Task completed successfully
//            }
//            .addOnFailureListener {
//                // Task failed with an exception
//            }

    }



}


