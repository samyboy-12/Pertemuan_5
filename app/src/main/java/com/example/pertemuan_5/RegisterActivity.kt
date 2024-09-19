package com.example.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailEditText = findViewById<EditText>(R.id.email)
        val fullnameEditText = findViewById<EditText>(R.id.fullname)
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val phoneEditText = findViewById<EditText>(R.id.phone)   // Nomor HP
        val genderEditText = findViewById<EditText>(R.id.gender)        // Gender

        val signUpButton = findViewById<Button>(R.id.signup_button)

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val fullname = fullnameEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val gender = genderEditText.text.toString()

            // Intent untuk berpindah ke halaman ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("email", email)
                putExtra("fullname", fullname)
                putExtra("username", username)
                putExtra("phone", phone)      // Passing nomor HP
                putExtra("gender", gender)    // Passing gender
            }
            startActivity(intent)
        }
    }
}
