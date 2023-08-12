package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById<Button>(R.id.btnStart)
        val txtName:EditText = findViewById(R.id.txtName)

        btnStart.setOnClickListener {
            if(txtName.text.isEmpty())
                Toast.makeText(this,
                    "Enter Your Name!", Toast.LENGTH_SHORT).show()
            else
            {
                val intent = Intent(this, Welcome_screen::class.java)
                intent.putExtra("name", txtName.text.toString())
                startActivity(intent) //it will move to other activity
               // finish() // it will close the previous activity after moving to other

            }
        }

    }
}