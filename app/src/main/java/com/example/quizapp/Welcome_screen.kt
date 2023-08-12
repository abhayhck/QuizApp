package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Welcome_screen : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val btnWelcomeStart: Button = findViewById(R.id.btnWelcomeStart)
        val txtWelcome:TextView = findViewById(R.id.txtWelcome)

        var name:String? = intent.getStringExtra("name")

        txtWelcome.text= "Welcome ${name.toString()}!"

        btnWelcomeStart.setOnClickListener {
            intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}