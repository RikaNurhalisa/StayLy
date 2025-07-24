package com.example.stayly

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FavoritActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorit)

        val tvEmpty = findViewById<TextView>(R.id.tvEmpty)

        // Ambil data favorit dari SharedPreferences
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val favorites = sharedPref.getStringSet("favorites", mutableSetOf())

        if (favorites.isNullOrEmpty()) {
            // Tampilkan pesan kosong
            tvEmpty.text = "Belum ada kos favorit ditambahkan."
        } else {
            // Gabungkan semua nama kos favorit jadi satu teks
            val result = favorites.joinToString(separator = "\n")
            tvEmpty.text = result
        }
    }
}
