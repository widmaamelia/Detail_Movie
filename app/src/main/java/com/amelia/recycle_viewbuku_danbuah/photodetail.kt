package com.amelia.recycle_viewbuku_danbuah

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class photodetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photodetail)


        // Get the image resource ID passed from the previous activity
        val imageResId = intent.getIntExtra("imageResId", 0)
        val title = intent.getStringExtra("title")


        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)

        imageView.setImageResource(imageResId)
        textViewTitle.text = title ?: "No Title"



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}