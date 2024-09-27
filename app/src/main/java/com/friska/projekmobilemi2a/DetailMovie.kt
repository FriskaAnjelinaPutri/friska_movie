package com.friska.projekmobilemi2a

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailMovie : AppCompatActivity() {
    private lateinit var txtDetailMovie: TextView
    private lateinit var imgDetailMovie: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_movie)

        txtDetailMovie = findViewById(R.id.txtDetailNamaMovie)
        imgDetailMovie = findViewById(R.id.imgDetailMovie)

        // Mendapatkan data dari intent
        val detailText = intent.getStringExtra("nama")
        val detailImg = intent.getIntExtra("image", 0)

        // Menetapkan data ke widget
        txtDetailMovie.text = detailText // Ubah ke 'text' dari 'setText'
        imgDetailMovie.setImageResource(detailImg)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
