package com.amelia.recycle_viewbuku_danbuah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amelia.recycle_viewbuku_danbuah.adapter.BukuAdapter
import com.amelia.recycle_viewbuku_danbuah.model.ModelBuku

class RecycleViewActivity : AppCompatActivity() {
    private lateinit var rv_data: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        rv_data = findViewById(R.id.rv_data)

// Define array data
        val listBuku = listOf(
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "memel"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "amelia"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "caramel"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "melia"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "amel"),
        )
        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}