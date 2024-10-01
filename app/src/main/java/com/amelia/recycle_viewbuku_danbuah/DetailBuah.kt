package com.amelia.recycle_viewbuku_danbuah

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBuah : AppCompatActivity() {
    private lateinit var txtDetailBuah: TextView
    private lateinit var imgDetailBuah: ImageView
    private lateinit var txtLokasi: TextView
    private lateinit var txtDeskripsi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_buah)

        txtDetailBuah = findViewById(R.id.txtDetailBuah)
        imgDetailBuah = findViewById(R.id.imgDetailBuah)
        txtLokasi = findViewById(R.id.txtLokasi)
        txtDeskripsi = findViewById(R.id.txtDeskripsi)

        val detailText = intent.getStringExtra("nama")
        val detailImg = intent.getIntExtra("image", 0 )
        val detailLokasi = intent.getStringExtra("lokasi")
        val detailDeskripsi = intent.getStringExtra("deskripsi")

        txtDetailBuah.setText(detailText)
        imgDetailBuah.setImageResource(detailImg)
        txtLokasi.setText(detailLokasi)
        txtDeskripsi.setText(detailDeskripsi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}