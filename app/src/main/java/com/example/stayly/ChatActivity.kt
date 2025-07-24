package com.example.stayly

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val namaKos = intent.getStringExtra("nama_kos") ?: "Kost"
        val pemilikId = intent.getStringExtra("pemilik_id") ?: "pemilik"

        val txtTitle = findViewById<TextView>(R.id.txtChatTitle)
        txtTitle.text = "Chat dengan Pemilik $namaKos"
    }
}
