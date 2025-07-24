package com.example.stayly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val fullName = findViewById<EditText>(R.id.full_name)
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirm_password)
        val daftarBtn = findViewById<Button>(R.id.btn_daftar)

        daftarBtn.setOnClickListener {
            val name = fullName.text.toString()
            val user = username.text.toString()
            val mail = email.text.toString()
            val pass = password.text.toString()
            val confirm = confirmPassword.text.toString()

            // Validasi sederhana
            if (name.isEmpty() || user.isEmpty() || mail.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            } else if (pass != confirm) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan ke SharedPreferences (opsional)
                val pref = getSharedPreferences("user_data", MODE_PRIVATE)
                with(pref.edit()) {
                    putString("username", user)
                    putString("email", mail)
                    apply()
                }

                // Langsung redirect ke Home / MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                Toast.makeText(this, "Berhasil daftar dan login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
