package com.example.signupsignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var signUp: Button
    lateinit var signIn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUp = findViewById(R.id.supBtn)
        signIn = findViewById(R.id.signIBtn)

        signIn.setOnClickListener {
            Intent(this, SignIn::class.java).apply {
                startActivity(this)
            }
        }

        signUp.setOnClickListener {

            Intent(this, SignUp::class.java).apply {
                startActivity(this)
            }

        }

    }
}