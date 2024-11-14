package com.example.learning2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar

import android.widget.TextView
import android.widget.Toast
import com.example.learning2.databinding.ActivityMainBinding


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

    }
}

