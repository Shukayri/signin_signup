package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var signinBtn: Button
    lateinit var signinMob: EditText
    lateinit var signinPw: EditText
    lateinit var password: String

    lateinit var sql: SQLdb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        signinMob = findViewById(R.id.siMobile)
        signinPw = findViewById(R.id.sipw)
        signinBtn = findViewById(R.id.gotosignin)

        sql = SQLdb(applicationContext)

        signinBtn.setOnClickListener {
            var s1 = signinMob.text.toString()
            var s2 = signinPw.text.toString()
            password = sql.check(s1)
            if(password == s2){
                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();
                val intent = Intent(this,HomePage::class.java).apply{
                    startActivity(this)
                }
            }else {
                Toast.makeText(applicationContext, "wrong details", Toast.LENGTH_SHORT).show();
            }

        }
    }
}