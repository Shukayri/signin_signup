package com.example.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var mobile: EditText
    lateinit var location: EditText
    lateinit var password: EditText
    lateinit var submitBtn: Button
    lateinit var sqlDB: SQLdb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name = findViewById(R.id.nameET)
        mobile = findViewById(R.id.mobET)
        location = findViewById(R.id.locET)
        password = findViewById(R.id.pwET)

        submitBtn = findViewById(R.id.submitBtn)

        sqlDB = SQLdb(this)


        submitBtn.setOnClickListener {
            var name = name.text.toString()
            var loc = location.text.toString()
            var mob = mobile.text.toString()
            var pw = password.toString()
            var s = sqlDB.savedata(name, loc, mob, pw)

            Toast.makeText(applicationContext, "saved successfully! ", Toast.LENGTH_SHORT).show();
            if(s.equals("-1")){
                Toast.makeText(applicationContext, "Error data not saved!", Toast.LENGTH_SHORT).show();
            }else{
                val intent1 = Intent(this,HomePage::class.java).apply {
                intent.putExtra("name", name)
                intent.putExtra("mobile", mob)
                intent.putExtra("location", loc)
                //startActivity(this)
            }
            startActivity(intent1)
            }
        }


    }
}