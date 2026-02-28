package com.example.codinground

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Loginpage : AppCompatActivity() {

    private var email: EditText? = null
    private var password: EditText? = null
    private var loginBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextNumberPassword)
        loginBtn = findViewById(R.id.button)

        loginBtn!!.setOnClickListener {

            val userEmail = email!!.text.toString().trim()
            val userPass = password!!.text.toString().trim()

            // ✅ Email empty
            if (userEmail.isEmpty()) {
                email!!.error = "Enter Email"
                email!!.requestFocus()
                return@setOnClickListener
            }

            // ✅ Email format
            if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                email!!.error = "Invalid Email"
                email!!.requestFocus()
                return@setOnClickListener
            }

            // ✅ Password empty
            if (userPass.isEmpty()) {
                password!!.error = "Enter Password"
                password!!.requestFocus()
                return@setOnClickListener
            }

            // ✅ Password length
            if (userPass.length < 4) {
                password!!.error = "Password must be 4+"
                password!!.requestFocus()
                return@setOnClickListener
            }

            // ✅ Dummy login (Interview purpose)
            if (userEmail == "amol@gmail.com" && userPass == "1234") {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(
                    this,
                    MainActivity::class.java
                )

                startActivity(intent)
                finish()

            } else {

                Toast.makeText(
                    this,
                    "Invalid Login",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}