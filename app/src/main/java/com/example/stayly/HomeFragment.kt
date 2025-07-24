package com.example.stayly

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("favorit_kos", Context.MODE_PRIVATE)

        val btnFavKos1 = view.findViewById<Button>(R.id.btnFavKos1)
        val btnFavKos2 = view.findViewById<Button>(R.id.btnFavKos2)
        val btnFavKos3 = view.findViewById<Button>(R.id.btnFavKos3)
        val btnFavKos4 = view.findViewById<Button>(R.id.btnFavKos4)

        val btnChatKos1 = view.findViewById<Button>(R.id.btnChatKos1)
        val btnChatKos2 = view.findViewById<Button>(R.id.btnChatKos2)
        val btnChatKos3 = view.findViewById<Button>(R.id.btnChatKos3)
        val btnChatKos4 = view.findViewById<Button>(R.id.btnChatKos4)

        btnFavKos1.setOnClickListener {
            sharedPref.edit().putBoolean("kos1", true).apply()
            Toast.makeText(requireContext(), "Kos Anggrek ditambahkan ke Favorit", Toast.LENGTH_SHORT).show()
        }

        btnFavKos2.setOnClickListener {
            sharedPref.edit().putBoolean("kos2", true).apply()
            Toast.makeText(requireContext(), "Kos Melati ditambahkan ke Favorit", Toast.LENGTH_SHORT).show()
        }

        btnFavKos3.setOnClickListener {
            sharedPref.edit().putBoolean("kos3", true).apply()
            Toast.makeText(requireContext(), "Kos Mawar ditambahkan ke Favorit", Toast.LENGTH_SHORT).show()
        }

        btnFavKos4.setOnClickListener {
            sharedPref.edit().putBoolean("kos4", true).apply()
            Toast.makeText(requireContext(), "Kos Cendrawasih ditambahkan ke Favorit", Toast.LENGTH_SHORT).show()
        }

        btnChatKos1.setOnClickListener {
            startChat("Kost Anggrek", "owner_kos1")
        }

        btnChatKos2.setOnClickListener {
            startChat("Kost Melati", "owner_kos2")
        }

        btnChatKos3.setOnClickListener {
            startChat("Kost Mawar", "owner_kos3")
        }

        btnChatKos4.setOnClickListener {
            startChat("Kost Cendrawasih", "owner_kos4")
        }
    }

    private fun startChat(namaKos: String, pemilikId: String) {
        val intent = Intent(requireContext(), ChatActivity::class.java)
        intent.putExtra("nama_kos", namaKos)
        intent.putExtra("pemilik_id", pemilikId)
        startActivity(intent)
    }
}
