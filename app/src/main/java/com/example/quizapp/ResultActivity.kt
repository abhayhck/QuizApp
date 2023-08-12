package com.example.quizapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.VideoView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntExtra("Result", 0)
        val max = intent.getIntExtra("max", 0)
        var txtResult:TextView= findViewById<TextView>(R.id.txtResult)
        var txtMax = findViewById<TextView>(R.id.txtMax)

        txtResult.text="${result.toString()} / "
        txtMax.text = max.toString()


        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://com.example.quizapp/${R.raw.congrats}")
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.setVolume(0f,0f)
        }

        videoView.setVideoURI(videoUri)
        videoView.start()

    }
}