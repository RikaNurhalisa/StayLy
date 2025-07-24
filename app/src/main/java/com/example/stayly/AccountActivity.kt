package com.example.stayly

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // cukup tutup halaman ini untuk kembali ke fragment/activity sebelumnya
        }
    }
}
