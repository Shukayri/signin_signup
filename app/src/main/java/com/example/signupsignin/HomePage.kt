package com.example.signupsignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomePage : AppCompatActivity() {
    lateinit var tvone: TextView
    lateinit var tvtwo: TextView
    lateinit var sqLdb: SQLdb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        sqLdb = SQLdb(this)



        val strname = intent.getStringExtra("name")
        val mobile = intent.getStringExtra("mobile")
        val loca = intent.getStringExtra("location")

        tvone = findViewById(R.id.tvOne)
        tvone.text = "Welcome $mobile"

        tvtwo = findViewById(R.id.tvTwo)
        tvtwo.text = "Your details are: \n$strname\n$loca"

    }
}