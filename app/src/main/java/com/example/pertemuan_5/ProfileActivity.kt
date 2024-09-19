package com.example.pertemuan_5

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    // Deklarasi variabel untuk komponen UI
    private lateinit var fullnameTextView: TextView
    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur layout activity_profile.xml
        setContentView(R.layout.activity_profile)

        // Inisialisasi komponen UI
        fullnameTextView = findViewById(R.id.fullname_text)
        usernameTextView = findViewById(R.id.username_text)
        emailTextView = findViewById(R.id.email_text)
        welcomeTextView = findViewById(R.id.welcome_text)

        // Menerima data dari LoginActivity
        val intentData = intent
        val fullname = intentData.getStringExtra("fullname")
        val username = intentData.getStringExtra("username")
        val email = intentData.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        val phoneTextView = findViewById<TextView>(R.id.profile_phone)
        val genderTextView = findViewById<TextView>(R.id.profile_gender)

        phoneTextView.text = "Phone Number: $phone"
        genderTextView.text = "Gender: $gender"

        // Menampilkan data ke TextView
        welcomeTextView.text = "Selamat datang, $username!"
        fullnameTextView.text = "Fullname: $fullname"
        usernameTextView.text = "Username: $username"
        emailTextView.text = "Email: $email"
    }
}
