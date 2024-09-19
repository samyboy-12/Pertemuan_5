package com.example.pertemuan_5


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    // Deklarasi variabel untuk komponen UI
    private lateinit var emailEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerLink: TextView

    // Variabel untuk menyimpan data yang diterima
    private var registeredEmail: String? = null
    private var fullname: String? = null
    private var username: String? = null
    private var password: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur layout activity_login.xml
        setContentView(R.layout.activity_login)

        // Inisialisasi komponen UI
        emailEditText = findViewById(R.id.email_login)
        loginButton = findViewById(R.id.login_button)
        registerLink = findViewById(R.id.register_link)

        // Menerima data dari RegisterActivity
        val intentData = intent
        registeredEmail = intentData.getStringExtra("email")
        fullname = intentData.getStringExtra("fullname")
        username = intentData.getStringExtra("username")
        password = intentData.getStringExtra("password")

        // Listener untuk tombol Login
        loginButton.setOnClickListener {
            val inputEmail = emailEditText.text.toString().trim()

            if (inputEmail.isEmpty()) {
                Toast.makeText(this, "Masukkan email", Toast.LENGTH_SHORT).show()
            } else {
                if (inputEmail == registeredEmail) {
                    // Jika email sesuai, pindah ke halaman profil
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("fullname", fullname)
                    intent.putExtra("username", username)
                    intent.putExtra("email", registeredEmail)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Email tidak terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Navigasi ke halaman registrasi jika belum memiliki akun
        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}